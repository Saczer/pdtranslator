package di.component

import dagger.Component
import di.module.ApplicationModule
import di.scope.PerApplication
import presentation.Translator

/**
 * @author molszak
 * created on 27.11.2017.
 */
@PerApplication
@Component(modules = arrayOf(
        ApplicationModule::class))
interface TranslationComponent {

    fun translator(): Translator

}