package pl.olszak.michal.pdtranslator.util

import org.junit.Before
import org.junit.Test

/**
 * @author molszak
 * created on 15.12.2017.
 */
class TextUtilsTest {

    lateinit var testText : String

    @Before
    fun init(){
        testText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus in molestie augue. Suspendisse massa erat, mattis" +
                "ut nibh nec, hendrerit lobortis nulla. Proin suscipit tortor nec rutrum tincidunt. Nunc id sem in nulla tristique lobortis." +
                " Mauris at velit id dolor tempor laoreet. Duis mauris diam, gravida ut gravida id, bibendum et nisl. Curabitur quis nunc augue. " +
                "Vestibulum eget libero sagittis, consectetur eros faucibus, pretium tellus."
    }

    @Test
    fun shouldFormatProperlyText(){
        val text = TextUtils.createUserReadableString(testText)
        println(text)
    }


}