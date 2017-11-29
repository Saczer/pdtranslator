package pl.olszak.michal.pdtranslator.domain.interactor.translation

import io.reactivex.Observable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.PublishSubject
import pl.olszak.michal.pdtranslator.domain.extractor.FileTextExtractor
import pl.olszak.michal.pdtranslator.domain.interactor.ObservableUseCase
import pl.olszak.michal.pdtranslator.model.google.TranslationApiResponse
import java.io.File
import javax.inject.Inject

/**
 * @author molszak
 * created on 29.11.2017.
 */
class FileTranslationUseCase @Inject constructor(
        private val translationUseCase: TranslationUseCase,
        private val fileTextExtractor: FileTextExtractor) : ObservableUseCase<TranslationApiResponse, File>() {

    private val subject = PublishSubject.create<TranslationApiResponse>()

    private val observer = object : DisposableSingleObserver<TranslationApiResponse>(){
        override fun onSuccess(t: TranslationApiResponse) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onError(e: Throwable) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    override fun buildObservable(params: File?): Observable<TranslationApiResponse> {
        if (params != null) {
            val disposable = fileTextExtractor.transform(params)
                    .subscribe({ list ->
                        val iterator = list.iterator()

                        if (!iterator.hasNext()) {
                            subject.onError(Throwable("List does not contain values"))
                        } else {

                            repository.getPolishTranslation(iterator.next())
                                    .subscribe({ response ->
                                        subject.onNext(response)
                                        if(iterator.hasNext()){
                                            repository.getPolishTranslation(iterator.next())
                                        }
                                    })
                        }
                    })
            addDisposable(disposable)
        }

        return subject
    }
}