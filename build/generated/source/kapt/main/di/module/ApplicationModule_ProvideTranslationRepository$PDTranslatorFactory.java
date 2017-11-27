package di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import data.translation.RestTranslationRepository;
import data.translation.TranslationRepository;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideTranslationRepository$PDTranslatorFactory
    implements Factory<TranslationRepository> {
  private final ApplicationModule module;

  private final Provider<RestTranslationRepository> repositoryProvider;

  public ApplicationModule_ProvideTranslationRepository$PDTranslatorFactory(
      ApplicationModule module, Provider<RestTranslationRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TranslationRepository get() {
    return Preconditions.checkNotNull(
        module.provideTranslationRepository$PDTranslator(repositoryProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TranslationRepository> create(
      ApplicationModule module, Provider<RestTranslationRepository> repositoryProvider) {
    return new ApplicationModule_ProvideTranslationRepository$PDTranslatorFactory(
        module, repositoryProvider);
  }
}
