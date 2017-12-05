package pl.olszak.michal.pdtranslator

import pl.olszak.michal.pdtranslator.di.component.DaggerTranslationComponent
import pl.olszak.michal.pdtranslator.di.component.TranslationComponent

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
            val fileCollectionController = component.collectionController()

            translator.translate("pp7.pdf")
            translator.getObservable()
                    .blockingSubscribe(fileCollectionController)
        }
    }
}