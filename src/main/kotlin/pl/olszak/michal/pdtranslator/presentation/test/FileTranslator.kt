package pl.olszak.michal.pdtranslator.presentation.test

import io.reactivex.Observable
import javax.xml.ws.Response

/**
 * @author molszak
 * created on 30.11.2017.
 */
interface FileTranslator {

    fun translate(filePath : String)

    fun getObservable() : Observable<Response<String>>

}