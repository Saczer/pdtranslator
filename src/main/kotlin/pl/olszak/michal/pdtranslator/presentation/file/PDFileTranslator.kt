package pl.olszak.michal.pdtranslator.presentation.file

import io.reactivex.Observable
import pl.olszak.michal.pdtranslator.domain.extractor.FileTextExtractor
import pl.olszak.michal.pdtranslator.model.remote.Response
import pl.olszak.michal.pdtranslator.presentation.translator.Translator
import java.io.File
import javax.inject.Inject

/**
 * @author molszak
 * created on 28.11.2017.
 */
class PDFileTranslator @Inject constructor(
        private val translator: Translator,
        private val textExtractor: FileTextExtractor) : FileTranslator {

    override fun translate(file: File) {
        textExtractor.transform(file)
                .subscribe({ list ->
                    val iterator = list.iterator()
                    if (!iterator.hasNext()) {
                        translator.dispose()
                    }

                    translator.getTranslation()
                            .doOnSubscribe { translator.translate(iterator.next()) }
                            .subscribe {
                                if (iterator.hasNext()) {
                                    translator.translate(iterator.next())
                                } else {
                                    translator.dispose()
                                }
                            }
                })
    }

    override fun getObservable(): Observable<Response<String>> = translator.getTranslation()

}