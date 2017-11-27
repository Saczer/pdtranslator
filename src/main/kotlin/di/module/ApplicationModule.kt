package di.module

import dagger.Module
import dagger.Provides
import data.translation.RestTranslationRepository
import data.translation.TranslationRepository
import di.scope.PerApplication
import domain.interactor.translation.TranslationUseCase
import presentation.TestTranslator
import presentation.Translator

/**
 * @author molszak
 * created on 27.11.2017.
 */
@PerApplication
@Module(includes = arrayOf(RestModule::class) )
class ApplicationModule {


    @Provides
    @PerApplication
    internal fun provideTranslationRepository(
            repository: RestTranslationRepository): TranslationRepository = repository


    @Provides
    @PerApplication
    internal fun provideTranslator(
            translationUseCase: TranslationUseCase): Translator = TestTranslator(translationUseCase)


}