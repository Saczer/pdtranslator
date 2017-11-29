package pl.olszak.michal.pdtranslator

import pl.olszak.michal.pdtranslator.di.component.DaggerTranslationComponent
import pl.olszak.michal.pdtranslator.di.component.TranslationComponent
import pl.olszak.michal.pdtranslator.model.remote.Status
import java.io.File

/**
 * @author molszak
 * created on 27.11.2017.
 */
class Application {

    fun component(): TranslationComponent {

        return DaggerTranslationComponent
                .builder()
                .build()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val component = Application().component()
            val translator = component.fileTranslator()

            val file = File("ep6.pdf")
            if (file.exists()) {
                translator.translate(file)
            } else {
                println("no file to translate")
            }

            translator.getObservable()
                    .blockingSubscribe { response ->
                        if (response.status == Status.ERROR) {
                            println("ERROR receiving : ${response.throwable?.toString()}")
                        } else {
                            println("translation: ${response.data}")
                        }
                    }


        }
    }
}