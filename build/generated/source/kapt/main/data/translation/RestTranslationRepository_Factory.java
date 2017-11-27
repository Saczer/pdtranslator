package data.translation;

import dagger.internal.Factory;
import data.RestService;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RestTranslationRepository_Factory implements Factory<RestTranslationRepository> {
  private final Provider<RestService> serviceProvider;

  public RestTranslationRepository_Factory(Provider<RestService> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public RestTranslationRepository get() {
    return new RestTranslationRepository(serviceProvider.get());
  }

  public static Factory<RestTranslationRepository> create(Provider<RestService> serviceProvider) {
    return new RestTranslationRepository_Factory(serviceProvider);
  }
}
