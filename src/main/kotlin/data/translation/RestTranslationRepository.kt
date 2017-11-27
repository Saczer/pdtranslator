package data.translation

import data.RestService
import io.reactivex.Single
import model.Language
import model.TranslationRequest
import model.google.TranslationApiResponse
import javax.inject.Inject

/**
 * @author molszak
 * created on 27.11.2017.
 */
class RestTranslationRepository @Inject constructor(private val service: RestService) : TranslationRepository {

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