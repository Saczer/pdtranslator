package pl.olszak.michal.pdtranslator.di.component

import dagger.Component
import pl.olszak.michal.pdtranslator.di.module.ApplicationModule
import pl.olszak.michal.pdtranslator.di.scope.PerApplication
import pl.olszak.michal.pdtranslator.presentation.Translator

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