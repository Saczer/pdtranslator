package pl.olszak.michal.pdtranslator.util

import java.io.ByteArrayInputStream

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

object TextUtils{

    fun createUserReadableString(string: String) : String{
        var chunk = 0
        val builder = StringBuilder()

        while (chunk < string.length){
            var endIndex = Math.min(chunk + 100, string.length)

            while (endIndex != string.length){
                val char = string[endIndex]
                if(char == ' ' || char == '.'){
                    break
                }else{
                    endIndex++
                }
            }
            builder.append(string.substring(chunk, endIndex))
            builder.append('\n')
            chunk = endIndex
        }


        return builder.toString()
    }

}

