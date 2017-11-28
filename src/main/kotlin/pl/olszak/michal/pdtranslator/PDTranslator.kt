package pl.olszak.michal.pdtranslator

import pl.olszak.michal.pdtranslator.di.component.DaggerTranslationComponent
import pl.olszak.michal.pdtranslator.di.component.TranslationComponent
import pl.olszak.michal.pdtranslator.model.api.Status

/**
 * @author molszak
 * created on 27.11.2017.
 */
class PDTranslator {

    fun component() : TranslationComponent {

        return DaggerTranslationComponent
                .builder()
                .build()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val component = PDTranslator().component()
            val translator = component.translator()

            var translated = false

            translator.getTranslation()
                    .subscribe({ response ->
                        if (response.status == Status.ERROR) {
                            println("ERROR receiving : ${response.throwable?.toString()}")
                        } else {
                            println("translation: ${response.data}")
                        }
                        translated = true
                    })

            translator.translate("I love my Agata")

            while (!translated){
                Thread.sleep(500)
            }
            println("something")


        }
    }
}