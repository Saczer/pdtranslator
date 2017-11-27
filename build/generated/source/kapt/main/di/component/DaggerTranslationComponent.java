package di.component;

import com.squareup.moshi.Moshi;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import data.RestService;
import data.translation.RestTranslationRepository;
import data.translation.RestTranslationRepository_Factory;
import data.translation.TranslationRepository;
import di.module.ApiModule;
import di.module.ApiModule_ProvideInterceptor$PDTranslatorFactory;
import di.module.ApiModule_ProvideMoshi$PDTranslatorFactory;
import di.module.ApiModule_ProvideOkHttp$PDTranslatorFactory;
import di.module.ApiModule_ProvideRestAdapter$PDTranslatorFactory;
import di.module.ApplicationModule;
import di.module.ApplicationModule_ProvideTranslationRepository$PDTranslatorFactory;
import di.module.ApplicationModule_ProvideTranslator$PDTranslatorFactory;
import di.module.RestModule;
import di.module.RestModule_ProvideRestService$PDTranslatorFactory;
import domain.interactor.translation.TranslationUseCase;
import domain.interactor.translation.TranslationUseCase_Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import presentation.Translator;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerTranslationComponent implements TranslationComponent {
  private Provider<Interceptor> provideInterceptor$PDTranslatorProvider;

  private Provider<OkHttpClient> provideOkHttp$PDTranslatorProvider;

  private Provider<Moshi> provideMoshi$PDTranslatorProvider;

  private Provider<Retrofit> provideRestAdapter$PDTranslatorProvider;

  private Provider<RestService> provideRestService$PDTranslatorProvider;

  private Provider<RestTranslationRepository> restTranslationRepositoryProvider;

  private Provider<TranslationRepository> provideTranslationRepository$PDTranslatorProvider;

  private Provider<TranslationUseCase> translationUseCaseProvider;

  private Provider<Translator> provideTranslator$PDTranslatorProvider;

  private DaggerTranslationComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static TranslationComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideInterceptor$PDTranslatorProvider =
        DoubleCheck.provider(
            ApiModule_ProvideInterceptor$PDTranslatorFactory.create(builder.apiModule));
    this.provideOkHttp$PDTranslatorProvider =
        DoubleCheck.provider(
            ApiModule_ProvideOkHttp$PDTranslatorFactory.create(
                builder.apiModule, provideInterceptor$PDTranslatorProvider));
    this.provideMoshi$PDTranslatorProvider =
        DoubleCheck.provider(ApiModule_ProvideMoshi$PDTranslatorFactory.create(builder.apiModule));
    this.provideRestAdapter$PDTranslatorProvider =
        DoubleCheck.provider(
            ApiModule_ProvideRestAdapter$PDTranslatorFactory.create(
                builder.apiModule,
                provideOkHttp$PDTranslatorProvider,
                provideMoshi$PDTranslatorProvider));
    this.provideRestService$PDTranslatorProvider =
        DoubleCheck.provider(
            RestModule_ProvideRestService$PDTranslatorFactory.create(
                builder.restModule, provideRestAdapter$PDTranslatorProvider));
    this.restTranslationRepositoryProvider =
        RestTranslationRepository_Factory.create(provideRestService$PDTranslatorProvider);
    this.provideTranslationRepository$PDTranslatorProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideTranslationRepository$PDTranslatorFactory.create(
                builder.applicationModule, restTranslationRepositoryProvider));
    this.translationUseCaseProvider =
        TranslationUseCase_Factory.create(provideTranslationRepository$PDTranslatorProvider);
    this.provideTranslator$PDTranslatorProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideTranslator$PDTranslatorFactory.create(
                builder.applicationModule, translationUseCaseProvider));
  }

  @Override
  public Translator translator() {
    return provideTranslator$PDTranslatorProvider.get();
  }

  public static final class Builder {
    private ApiModule apiModule;

    private RestModule restModule;

    private ApplicationModule applicationModule;

    private Builder() {}

    public TranslationComponent build() {
      if (apiModule == null) {
        this.apiModule = new ApiModule();
      }
      if (restModule == null) {
        this.restModule = new RestModule();
      }
      if (applicationModule == null) {
        this.applicationModule = new ApplicationModule();
      }
      return new DaggerTranslationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder restModule(RestModule restModule) {
      this.restModule = Preconditions.checkNotNull(restModule);
      return this;
    }

    public Builder apiModule(ApiModule apiModule) {
      this.apiModule = Preconditions.checkNotNull(apiModule);
      return this;
    }
  }
}
