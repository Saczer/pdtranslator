package pl.olszak.michal.pdtranslator.di.module

import dagger.Module
import dagger.Provides
import pl.olszak.michal.pdtranslator.data.TranslationRepository
import pl.olszak.michal.pdtranslator.data.remote.translation.EnglishTranslationRepository
import pl.olszak.michal.pdtranslator.di.scope.PerApplication
import pl.olszak.michal.pdtranslator.domain.extractor.pdf.PDFileTextExtractor
import pl.olszak.michal.pdtranslator.domain.interactor.translation.TranslateText
import pl.olszak.michal.pdtranslator.presentation.file.FileTranslator
import pl.olszak.michal.pdtranslator.presentation.file.PDFileTranslator
import pl.olszak.michal.pdtranslator.presentation.translator.TextTranslator
import pl.olszak.michal.pdtranslator.presentation.translator.Translator
import pl.olszak.michal.pdtranslator.util.PropertiesUtil
import java.util.*
import javax.inject.Named

/**
 * @author molszak
 * created on 27.11.2017.
 */
@PerApplication
@Module(includes = arrayOf(ApiModule::class))
class ApplicationModule {

    @Provides
    @PerApplication
    fun provideTranslationRepository(repository: EnglishTranslationRepository): TranslationRepository = repository

    @Provides
    @PerApplication
    fun provideTranslationUseCase(
            repository: TranslationRepository): TranslateText = TranslateText(repository)

    @Provides
    @PerApplication
    fun provideTranslator(
            translateText: TranslateText): Translator = TextTranslator(translateText)

    @Provides
    @PerApplication
    fun provideFileTranslator(translator: Translator): FileTranslator {
        return PDFileTranslator(translator, PDFileTextExtractor())
    }

    @Provides
    @PerApplication
    @Named("serviceKey")
    fun provideServiceKey(properties: Properties): String {
        return properties.getProperty("serviceKey")
    }

    @Provides
    @PerApplication
    @Named("remoteUrl")
    fun provideUrl(properties: Properties): String {
        return properties.getProperty("remoteUrl")
    }

    @Provides
    @PerApplication
    fun provideProperties(): Properties {
        return PropertiesUtil.loadProperties()
    }


}