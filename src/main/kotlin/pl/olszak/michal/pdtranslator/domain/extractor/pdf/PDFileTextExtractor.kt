package pl.olszak.michal.pdtranslator.domain.extractor.pdf

import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import pl.olszak.michal.pdtranslator.domain.extractor.FileTextExtractor
import pl.olszak.michal.pdtranslator.util.trimFromNewLines
import java.io.File
import java.util.*

/**
 * @author molszak
 * created on 28.11.2017.
 */
class PDFileTextExtractor : FileTextExtractor {

    override fun transform(file: File): Single<List<String>> {
        return Single.create(FileTransformer(file))
    }

    private class FileTransformer constructor(private val file: File) : SingleOnSubscribe<List<String>> {
        override fun subscribe(emitter: SingleEmitter<List<String>>) {
            val list: MutableList<String> = LinkedList()

            try {
                val document = PDDocument.load(file)
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
                document.close()
            } catch (t: Throwable) {
                emitter.onError(t)
            }
        }
    }

}