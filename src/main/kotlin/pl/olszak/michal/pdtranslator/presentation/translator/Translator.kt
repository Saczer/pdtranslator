package pl.olszak.michal.pdtranslator.presentation.translator

import io.reactivex.Observable
import pl.olszak.michal.pdtranslator.model.remote.Response

/**
 * @author molszak
 * created on 27.11.2017.
 */
interface Translator {

    fun translate(text : String)

    fun getTranslation() : Observable<Response<String>>

    fun dispose()

}