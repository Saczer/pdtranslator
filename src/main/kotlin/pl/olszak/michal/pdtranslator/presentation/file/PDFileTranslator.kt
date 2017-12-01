package pl.olszak.michal.pdtranslator.presentation.file

import io.reactivex.Observable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.PublishSubject
import pl.olszak.michal.pdtranslator.domain.interactor.extraction.ExtractTextFromFile
import pl.olszak.michal.pdtranslator.domain.interactor.translation.TranslateText
import pl.olszak.michal.pdtranslator.model.google.TranslationApiResponse
import pl.olszak.michal.pdtranslator.model.remote.Response
import javax.inject.Inject

/**
 * @author molszak
 * created on 30.11.2017.
 */
class PDFileTranslator @Inject constructor(
        private val textFromFile: ExtractTextFromFile,
        private val translateText: TranslateText) : FileTranslator {

    private val subject = PublishSubject.create<Response<String>>()
            .toSerialized()

    override fun translate(filePath: String) {
        textFromFile.execute(object : DisposableSingleObserver<List<String>>() {
            override fun onError(e: Throwable) {
                subject.onNext(Response.error(e))
            }

            override fun onSuccess(list: List<String>) {
                onListReturn(list)
            }

        }, filePath)
    }

    private fun onListReturn(list: List<String>) {
        val iterator = list.iterator()
        if(!iterator.hasNext()){
            subject.onComplete()
            return
        }

        translate(iterator)
    }

    private fun translate(iterator: Iterator<String>){
        translateText.execute(object : DisposableSingleObserver<TranslationApiResponse>() {
            override fun onSuccess(translation: TranslationApiResponse) {
                val output = translation.data
                        .translations
                        .filter { response -> response.translatedText.isNotEmpty() }
                        .joinToString { response ->
                            response.translatedText + "."
                        }

                subject.onNext(Response.success(output))

                if(iterator.hasNext()){
                    translate(iterator)
                }else{
                    subject.onComplete()
                }
            }

            override fun onError(e: Throwable) {
                subject.onNext(Response.error(e))
            }

        }, iterator.next())
    }

    override fun getObservable(): Observable<Response<String>> = subject

}