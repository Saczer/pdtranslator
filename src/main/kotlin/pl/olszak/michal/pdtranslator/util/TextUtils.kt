package pl.olszak.michal.pdtranslator.util

/**
 * @author molszak
 * created on 29.11.2017.
 */
fun String.trimFromNewLines() : String{
    if(this.isEmpty()) return this
    return this
            .replace("\r", "", true)
            .replace("\n", "",true)
            .replace(Regex("\\s+"), " ");
}