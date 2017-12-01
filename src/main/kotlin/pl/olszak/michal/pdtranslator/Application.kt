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

            translator.translate("ep6.pdf")
            translator.getObservable()
                    .blockingSubscribe { response ->
                        when(response.status){
                            Status.ERROR -> println(response.throwable?.localizedMessage ?: "error")
                            Status.SUCCESS -> println(response.data)
                        }
                    }
        }
    }
}