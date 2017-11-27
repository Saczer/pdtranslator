package domain.interactor.translation;

import dagger.internal.Factory;
import data.translation.TranslationRepository;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TranslationUseCase_Factory implements Factory<TranslationUseCase> {
  private final Provider<TranslationRepository> repositoryProvider;

  public TranslationUseCase_Factory(Provider<TranslationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TranslationUseCase get() {
    return new TranslationUseCase(repositoryProvider.get());
  }

  public static Factory<TranslationUseCase> create(
      Provider<TranslationRepository> repositoryProvider) {
    return new TranslationUseCase_Factory(repositoryProvider);
  }
}
