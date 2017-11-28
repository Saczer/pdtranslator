package pl.olszak.michal.pdtranslator.domain.transformer.pdf

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import pl.olszak.michal.pdtranslator.domain.transformer.FileTransformer
import java.io.File
import java.util.*

/**
 * REPLACE THIS WITH SOME OBSERVABLE SOURCE
 *
 * @author molszak
 * created on 28.11.2017.
 */
class PDFileTransformer : FileTransformer {

    override fun transform(file: File): List<String> {
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
            val transformed = pageText
                    .replace("\r", " ", true)
                    .replace("\n", " ", true)
                    .replace(Regex("\\s+"), " ")
            list.add(transformed)
        }

        document.close()
        return list
    }

}