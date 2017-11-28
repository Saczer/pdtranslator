package pl.olszak.michal.pdtranslator.data.translation

import io.reactivex.Single
import pl.olszak.michal.pdtranslator.model.google.TranslationApiResponse

/**
 * @author molszak
 * created on 27.11.2017.
 */
interface TranslationRepository {

    fun getPolishTranslation(text : String) : Single<TranslationApiResponse>

}