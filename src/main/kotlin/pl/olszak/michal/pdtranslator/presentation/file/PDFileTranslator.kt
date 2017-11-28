package pl.olszak.michal.pdtranslator.presentation.file

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import pl.olszak.michal.pdtranslator.domain.transformer.FileTransformer
import pl.olszak.michal.pdtranslator.model.api.Response
import pl.olszak.michal.pdtranslator.presentation.translator.Translator
import java.io.File
import javax.inject.Inject

/**
 * @author molszak
 * created on 28.11.2017.
 */
class PDFileTranslator @Inject constructor(
        private val translator: Translator,
        private val transformer: FileTransformer) : FileTranslator {

    private val subject: PublishSubject<Response<String>> = PublishSubject.create()

    override fun translate(file: File) {
        val list = transformer.transform(file)

        if (!list.isEmpty()) {
            val iterator = list.iterator()
            translator.getTranslation()
                    .doOnSubscribe({
                        translator.translate(iterator.next())
                    })
                    .subscribe({ response ->
                        subject.onNext(response)
                        if(iterator.hasNext()){
                            translator.translate(iterator.next())
                        }else{
                            subject.onComplete()
                        }
                    })
        }else{
            subject.onComplete()
        }
    }

    override fun getObservable(): Observable<Response<String>> = subject

}