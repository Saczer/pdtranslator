package presentation

import io.reactivex.Observable
import model.api.Response
import java.io.File

/**
 * @author molszak
 * created on 27.11.2017.
 */
interface Translator {

    fun translate(text : String)

    fun getTranslation() : Observable<Response<String>>

    fun translate(input : File)

}