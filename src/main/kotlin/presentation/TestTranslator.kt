package presentation

import domain.interactor.translation.TranslationUseCase
import io.reactivex.Observable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.PublishSubject
import model.api.Response
import model.google.TranslationApiResponse
import java.io.File
import javax.inject.Inject

/**
 * @author molszak
 * created on 27.11.2017.
 */
class TestTranslator @Inject constructor(private val translationUseCase: TranslationUseCase) : Translator {

    private val subject: PublishSubject<Response<String>> = PublishSubject.create()

    override fun translate(text: String) {

        translationUseCase.execute(singleObserver = object : DisposableSingleObserver<TranslationApiResponse>() {
            override fun onSuccess(translation: TranslationApiResponse) {
                val output = translation.data
                        .translations
                        .joinToString { response ->
                            response.translatedText + "\n"
                        }

                subject.onNext(Response.success(output))
            }

            override fun onError(error: Throwable) {
                subject.onNext(Response.error(error))
            }

        })
    }

    override fun getTranslation(): Observable<Response<String>> = subject

    override fun translate(input: File) {
    }
}