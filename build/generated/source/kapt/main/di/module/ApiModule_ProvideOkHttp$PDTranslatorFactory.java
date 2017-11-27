package di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideOkHttp$PDTranslatorFactory implements Factory<OkHttpClient> {
  private final ApiModule module;

  private final Provider<Interceptor> interceptorProvider;

  public ApiModule_ProvideOkHttp$PDTranslatorFactory(
      ApiModule module, Provider<Interceptor> interceptorProvider) {
    this.module = module;
    this.interceptorProvider = interceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideOkHttp$PDTranslator(interceptorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(
      ApiModule module, Provider<Interceptor> interceptorProvider) {
    return new ApiModule_ProvideOkHttp$PDTranslatorFactory(module, interceptorProvider);
  }
}
