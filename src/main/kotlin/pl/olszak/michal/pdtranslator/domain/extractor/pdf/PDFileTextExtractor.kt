package pl.olszak.michal.pdtranslator.domain.extractor.pdf

import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException
import org.apache.pdfbox.text.PDFTextStripper
import pl.olszak.michal.pdtranslator.domain.extractor.FileTextExtractor
import pl.olszak.michal.pdtranslator.util.trimFromNewLines
import java.io.File
import java.io.IOException
import java.util.*

/**
 * @author molszak
 * created on 28.11.2017.
 */
class PDFileTextExtractor : FileTextExtractor {

    override fun transform(file: File): Single<List<String>> {
        return Single.create(FileTransformer(file))
    }

    private class FileTransformer constructor(private val file: File): SingleOnSubscribe<List<String>>{
        override fun subscribe(emitter: SingleEmitter<List<String>>) {
            val list: MutableList<String> = LinkedList()

            try {
                PDDocument.load(file).use { document ->
                    if (document.isEncrypted) {
                        emitter.onSuccess(emptyList())
                    }

                    val stripper = PDFTextStripper()
                    for (i in 0..document.pages.count) {
                        stripper.startPage = i
                        stripper.endPage = i

                        val pageText = stripper.getText(document)
                        val transformed = pageText.trimFromNewLines()

                        list.add(transformed)
                    }

                    emitter.onSuccess(list)
                }
            }catch (throwable : Throwable){
                when(throwable){
                    is IOException -> emitter.onError(IOException("Could not open file", throwable))
                    is InvalidPasswordException -> emitter.onError(IOException("The file is encrypted", throwable))
                    else -> emitter.onError(throwable)
                }
            }
        }

    }

}