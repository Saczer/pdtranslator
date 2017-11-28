package pl.olszak.michal.pdtranslator.domain.transformer

import java.io.File

/**
 * @author molszak
 * created on 28.11.2017.
 */
interface FileTransformer {

    fun transform(file : File) : List<String>

}