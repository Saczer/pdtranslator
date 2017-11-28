package pl.olszak.michal.pdtranslator.presentation.file

import io.reactivex.Observable
import pl.olszak.michal.pdtranslator.model.api.Response
import java.io.File

/**
 * @author molszak
 * created on 28.11.2017.
 */
interface FileTranslator {

    fun translate(file : File)

    fun getObservable() : Observable<Response<String>>

}