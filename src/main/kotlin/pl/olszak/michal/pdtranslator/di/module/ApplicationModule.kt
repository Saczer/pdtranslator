package pl.olszak.michal.pdtranslator.di.module

import dagger.Module
import dagger.Provides
import pl.olszak.michal.pdtranslator.data.translation.StubTranslationRepository
import pl.olszak.michal.pdtranslator.data.translation.TranslationRepository
import pl.olszak.michal.pdtranslator.di.scope.PerApplication
import pl.olszak.michal.pdtranslator.domain.interactor.translation.TranslationUseCase
import pl.olszak.michal.pdtranslator.domain.transformer.pdf.PDFileTransformer
import pl.olszak.michal.pdtranslator.presentation.file.FileTranslator
import pl.olszak.michal.pdtranslator.presentation.file.PDFileTranslator
import pl.olszak.michal.pdtranslator.presentation.translator.TextTranslator
import pl.olszak.michal.pdtranslator.presentation.translator.Translator

/**
 * @author molszak
 * created on 27.11.2017.
 */
@PerApplication
@Module(includes = arrayOf(ApiModule::class))
class ApplicationModule {

    @Provides
    @PerApplication
    fun provideTranslationRepository(repository: StubTranslationRepository): TranslationRepository = repository

    @Provides
    @PerApplication
    fun provideTranslationUseCase(
            repository: TranslationRepository): TranslationUseCase = TranslationUseCase(repository)

    @Provides
    @PerApplication
    fun provideTranslator(
            translationUseCase: TranslationUseCase): Translator = TextTranslator(translationUseCase)

    @Provides
    @PerApplication
    fun provideFileTranslator(translator: Translator): FileTranslator {
        return PDFileTranslator(translator, PDFileTransformer())
    }


}