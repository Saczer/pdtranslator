package pl.olszak.michal.pdtranslator.presentation.file

import io.reactivex.Observable
import pl.olszak.michal.pdtranslator.model.remote.Response

/**
 * @author molszak
 * created on 30.11.2017.
 */
interface FileTranslator {

    fun translate(filePath : String)

    fun getObservable() : Observable<Response<String>>

}