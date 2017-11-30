package pl.olszak.michal.pdtranslator.util

import java.io.IOException
import java.util.*

/**
 * @author molszak
 * created on 30.11.2017.
 */
object PropertiesUtil {

    private val propertiesFilename = "keys/server_keys.properties"

    fun loadProperties() : Properties{
        val properties = Properties()

        try {
            javaClass.classLoader.getResourceAsStream(propertiesFilename)
                    .use { properties.load(it) }
        } catch (ex: IOException) {
            println(ex.localizedMessage)
            TODO("should change the exception handling, some logger implementation")
        }

        return properties
    }

}