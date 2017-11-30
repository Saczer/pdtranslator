package pl.olszak.michal.pdtranslator.presentation.test

import io.reactivex.Observable
import pl.olszak.michal.pdtranslator.domain.interactor.extraction.ExtractTextFromFile
import pl.olszak.michal.pdtranslator.domain.interactor.translation.TranslateText
import javax.inject.Inject
import javax.xml.ws.Response

/**
 * @author molszak
 * created on 30.11.2017.
 */
class PDFileTranslator @Inject constructor(
        private val extractionUseCase: ExtractTextFromFile,
        private val translationUseCase: TranslateText) : FileTranslator{

    override fun translate(filePath: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getObservable(): Observable<Response<String>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}