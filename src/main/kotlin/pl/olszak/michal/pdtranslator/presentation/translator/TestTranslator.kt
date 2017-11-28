package pl.olszak.michal.pdtranslator.presentation.translator

import io.reactivex.Observable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.PublishSubject
import pl.olszak.michal.pdtranslator.domain.interactor.translation.StubTranslationUseCase
import pl.olszak.michal.pdtranslator.model.api.Response
import pl.olszak.michal.pdtranslator.model.google.TranslationApiResponse
import javax.inject.Inject

/**
 * @author molszak
 * created on 27.11.2017.
 */
class TestTranslator @Inject constructor(private val translationUseCase: StubTranslationUseCase) : Translator {

    private val subject: PublishSubject<Response<String>> = PublishSubject.create()

    override fun translate(text: String) {

        translationUseCase.execute(singleObserver = object : DisposableSingleObserver<TranslationApiResponse>() {
            override fun onSuccess(translation: TranslationApiResponse) {
                val output = translation.data
                        .translations
                        .joinToString { response ->
                            response.translatedText
                        }

                subject.onNext(Response.success(output))
            }

            override fun onError(error: Throwable) {
                subject.onNext(Response.error(error))
            }

        }, params = text)
    }

    override fun getTranslation(): Observable<Response<String>> = subject

}