package di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import domain.interactor.translation.TranslationUseCase;
import javax.annotation.Generated;
import javax.inject.Provider;
import presentation.Translator;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideTranslator$PDTranslatorFactory
    implements Factory<Translator> {
  private final ApplicationModule module;

  private final Provider<TranslationUseCase> translationUseCaseProvider;

  public ApplicationModule_ProvideTranslator$PDTranslatorFactory(
      ApplicationModule module, Provider<TranslationUseCase> translationUseCaseProvider) {
    this.module = module;
    this.translationUseCaseProvider = translationUseCaseProvider;
  }

  @Override
  public Translator get() {
    return Preconditions.checkNotNull(
        module.provideTranslator$PDTranslator(translationUseCaseProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Translator> create(
      ApplicationModule module, Provider<TranslationUseCase> translationUseCaseProvider) {
    return new ApplicationModule_ProvideTranslator$PDTranslatorFactory(
        module, translationUseCaseProvider);
  }
}
