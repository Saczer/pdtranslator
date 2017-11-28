package di.module;

import dagger.Module;
import dagger.Provides;
import data.translation.RestTranslationRepository;
import data.translation.TranslationRepository;
import di.scope.PerApplication;
import domain.interactor.translation.TranslationUseCase;
import presentation.TestTranslator;
import presentation.Translator;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u00a2\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0001\u00a2\u0006\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Ldi/module/ApplicationModule;", "", "()V", "provideTranslationRepository", "Ldata/translation/TranslationRepository;", "repository", "Ldata/translation/RestTranslationRepository;", "provideTranslationRepository$PDTranslator", "provideTranslationUseCase", "Ldomain/interactor/translation/TranslationUseCase;", "provideTranslationUseCase$PDTranslator", "provideTranslator", "Lpresentation/Translator;", "translationUseCase", "provideTranslator$PDTranslator", "PDTranslator"})
@dagger.Module()
@di.scope.PerApplication()
public final class ApplicationModule {
    
    @org.jetbrains.annotations.NotNull()
    @di.scope.PerApplication()
    @dagger.Provides()
    public final data.translation.TranslationRepository provideTranslationRepository$PDTranslator(@org.jetbrains.annotations.NotNull()
    data.translation.RestTranslationRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @di.scope.PerApplication()
    @dagger.Provides()
    public final domain.interactor.translation.TranslationUseCase provideTranslationUseCase$PDTranslator(@org.jetbrains.annotations.NotNull()
    data.translation.TranslationRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @di.scope.PerApplication()
    @dagger.Provides()
    public final presentation.Translator provideTranslator$PDTranslator(@org.jetbrains.annotations.NotNull()
    domain.interactor.translation.TranslationUseCase translationUseCase) {
        return null;
    }
    
    public ApplicationModule() {
        super();
    }
}