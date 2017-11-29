package pl.olszak.michal.pdtranslator.data.remote.translation

import pl.olszak.michal.pdtranslator.data.remote.RestService
import io.reactivex.Single
import pl.olszak.michal.pdtranslator.data.TranslationRepository
import pl.olszak.michal.pdtranslator.model.Language
import pl.olszak.michal.pdtranslator.model.TranslationRequest
import pl.olszak.michal.pdtranslator.model.google.TranslationApiResponse
import javax.inject.Inject

/**
 * @author molszak
 * created on 27.11.2017.
 */
class EnglishTranslationRepository @Inject constructor(private val service: RestService) : TranslationRepository {

    override fun getPolishTranslation(text: String): Single<TranslationApiResponse> {
        val request = TranslationRequest(
                text,
                Language.EN,
                Language.PL)

        return service.translate(
                request.toTranslate,
                request.targetLanguage.code,
                "text",
                request.sourceLanguage.code)
    }
}