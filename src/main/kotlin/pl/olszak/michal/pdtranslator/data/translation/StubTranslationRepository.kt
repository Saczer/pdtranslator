package pl.olszak.michal.pdtranslator.data.translation

import io.reactivex.Single
import pl.olszak.michal.pdtranslator.model.google.TranslatedTextResponse
import pl.olszak.michal.pdtranslator.model.google.TranslatedTextResponseList
import pl.olszak.michal.pdtranslator.model.google.TranslationApiResponse
import javax.inject.Inject

/**
 * @author molszak
 * created on 28.11.2017.
 */
class StubTranslationRepository @Inject constructor(): TranslationRepository {

    override fun getPolishTranslation(text: String): Single<TranslationApiResponse> {
        return Single.just(TranslationApiResponse(TranslatedTextResponseList(listOf(TranslatedTextResponse(text)))))
    }
}