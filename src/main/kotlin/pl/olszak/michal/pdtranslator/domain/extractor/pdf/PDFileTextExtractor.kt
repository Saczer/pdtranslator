package pl.olszak.michal.pdtranslator.domain.extractor.pdf

import io.reactivex.Single
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
        return Single.fromCallable({
            transformFile(file)
        })
    }

    private fun transformFile(file: File): List<String> {
        val list: MutableList<String> = LinkedList()

        val document = PDDocument.load(file)
        if (document.isEncrypted) {
            return emptyList()
        }

        val stripper = PDFTextStripper()
        for (i in 0..document.pages.count) {
            stripper.startPage = i
            stripper.endPage = i

            val pageText = stripper.getText(document)
            val transformed = pageText.trimFromNewLines()

            list.add(transformed)
        }

        document.close()
        return list
    }

}