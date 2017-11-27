package di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import data.RestService;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RestModule_ProvideRestService$PDTranslatorFactory
    implements Factory<RestService> {
  private final RestModule module;

  private final Provider<Retrofit> adapterProvider;

  public RestModule_ProvideRestService$PDTranslatorFactory(
      RestModule module, Provider<Retrofit> adapterProvider) {
    this.module = module;
    this.adapterProvider = adapterProvider;
  }

  @Override
  public RestService get() {
    return Preconditions.checkNotNull(
        module.provideRestService$PDTranslator(adapterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RestService> create(RestModule module, Provider<Retrofit> adapterProvider) {
    return new RestModule_ProvideRestService$PDTranslatorFactory(module, adapterProvider);
  }
}
