package data.translation

import io.reactivex.Single
import model.google.TranslationApiResponse

/**
 * @author molszak
 * created on 27.11.2017.
 */
interface TranslationRepository {

    fun getPolishTranslation(text : String) : Single<TranslationApiResponse>

}