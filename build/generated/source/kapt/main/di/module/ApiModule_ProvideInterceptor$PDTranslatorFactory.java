package di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.Interceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideInterceptor$PDTranslatorFactory
    implements Factory<Interceptor> {
  private final ApiModule module;

  public ApiModule_ProvideInterceptor$PDTranslatorFactory(ApiModule module) {
    this.module = module;
  }

  @Override
  public Interceptor get() {
    return Preconditions.checkNotNull(
        module.provideInterceptor$PDTranslator(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Interceptor> create(ApiModule module) {
    return new ApiModule_ProvideInterceptor$PDTranslatorFactory(module);
  }
}
