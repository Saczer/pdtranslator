package di.module;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideMoshi$PDTranslatorFactory implements Factory<Moshi> {
  private final ApiModule module;

  public ApiModule_ProvideMoshi$PDTranslatorFactory(ApiModule module) {
    this.module = module;
  }

  @Override
  public Moshi get() {
    return Preconditions.checkNotNull(
        module.provideMoshi$PDTranslator(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Moshi> create(ApiModule module) {
    return new ApiModule_ProvideMoshi$PDTranslatorFactory(module);
  }
}
