package pl.olszak.michal.pdtranslator.di.component

import dagger.Component
import pl.olszak.michal.pdtranslator.di.module.ApplicationModule
import pl.olszak.michal.pdtranslator.di.scope.PerApplication
import pl.olszak.michal.pdtranslator.domain.interactor.collection.CollectToFile
import pl.olszak.michal.pdtranslator.presentation.FileCollectionController
import pl.olszak.michal.pdtranslator.presentation.file.FileTranslator

/**
 * @author molszak
 * created on 27.11.2017.
 */
@PerApplication
@Component(modules = arrayOf(
        ApplicationModule::class))
interface TranslationComponent {

    fun fileTranslator() : FileTranslator

    fun collectionController() : FileCollectionController

}