package di.module;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideRestAdapter$PDTranslatorFactory implements Factory<Retrofit> {
  private final ApiModule module;

  private final Provider<OkHttpClient> clientProvider;

  private final Provider<Moshi> moshiProvider;

  public ApiModule_ProvideRestAdapter$PDTranslatorFactory(
      ApiModule module, Provider<OkHttpClient> clientProvider, Provider<Moshi> moshiProvider) {
    this.module = module;
    this.clientProvider = clientProvider;
    this.moshiProvider = moshiProvider;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.provideRestAdapter$PDTranslator(clientProvider.get(), moshiProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(
      ApiModule module, Provider<OkHttpClient> clientProvider, Provider<Moshi> moshiProvider) {
    return new ApiModule_ProvideRestAdapter$PDTranslatorFactory(
        module, clientProvider, moshiProvider);
  }
}
