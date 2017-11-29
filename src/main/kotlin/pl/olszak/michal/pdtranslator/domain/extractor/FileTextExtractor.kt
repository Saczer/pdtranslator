package pl.olszak.michal.pdtranslator.domain.extractor

import io.reactivex.Single
import java.io.File

/**
 * @author molszak
 * created on 28.11.2017.
 */
interface FileTextExtractor {

    fun transform(file : File) : Single<List<String>>

}