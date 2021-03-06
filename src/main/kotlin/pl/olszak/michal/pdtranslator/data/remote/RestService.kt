package pl.olszak.michal.pdtranslator.data.remote

import io.reactivex.Single
import pl.olszak.michal.pdtranslator.model.google.TranslationApiResponse
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * @author molszak
 * created on 27.11.2017.
 */
interface RestService {

    @POST("/language/translate/v2")
    fun translate(
            @Query("q") translationText: String,
            @Query("target") targetLanguage: String,
            @Query("format") format: String,
            @Query("source") sourceLanguage: String) : Single<TranslationApiResponse>

}