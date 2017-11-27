package presentation;

import dagger.internal.Factory;
import domain.interactor.translation.TranslationUseCase;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TestTranslator_Factory implements Factory<TestTranslator> {
  private final Provider<TranslationUseCase> translationUseCaseProvider;

  public TestTranslator_Factory(Provider<TranslationUseCase> translationUseCaseProvider) {
    this.translationUseCaseProvider = translationUseCaseProvider;
  }

  @Override
  public TestTranslator get() {
    return new TestTranslator(translationUseCaseProvider.get());
  }

  public static Factory<TestTranslator> create(
      Provider<TranslationUseCase> translationUseCaseProvider) {
    return new TestTranslator_Factory(translationUseCaseProvider);
  }
}
