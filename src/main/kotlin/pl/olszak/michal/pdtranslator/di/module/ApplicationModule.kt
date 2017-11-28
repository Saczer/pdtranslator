package pl.olszak.michal.pdtranslator.di.module

import dagger.Module
import dagger.Provides
import pl.olszak.michal.pdtranslator.data.translation.RestTranslationRepository
import pl.olszak.michal.pdtranslator.data.translation.TranslationRepository
import pl.olszak.michal.pdtranslator.di.scope.PerApplication
import pl.olszak.michal.pdtranslator.domain.interactor.translation.TranslationUseCase
import pl.olszak.michal.pdtranslator.presentation.TestTranslator
import pl.olszak.michal.pdtranslator.presentation.Translator

/**
 * @author molszak
 * created on 27.11.2017.
 */
@PerApplication
@Module(includes = arrayOf(ApiModule::class))
class ApplicationModule{

    @Provides
    @PerApplication
    fun provideTranslationRepository(repository: RestTranslationRepository): TranslationRepository = repository

    @Provides
    @PerApplication
    fun provideTranslationUseCase(
            repository: TranslationRepository): TranslationUseCase = TranslationUseCase(repository)

    @Provides
    @PerApplication
    fun provideTranslator(
            translationUseCase: TranslationUseCase): Translator = TestTranslator(translationUseCase)


}