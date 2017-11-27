package di.module;

import com.squareup.moshi.KotlinJsonAdapterFactory;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import data.Constants;
import di.scope.PerApplication;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0001\u00a2\u0006\u0002\b\u0005J\r\u0010\u0006\u001a\u00020\u0007H\u0001\u00a2\u0006\u0002\b\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0001\u00a2\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0007H\u0001\u00a2\u0006\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Ldi/module/ApiModule;", "", "()V", "provideInterceptor", "Lokhttp3/Interceptor;", "provideInterceptor$PDTranslator", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "provideMoshi$PDTranslator", "provideOkHttp", "Lokhttp3/OkHttpClient;", "interceptor", "provideOkHttp$PDTranslator", "provideRestAdapter", "Lretrofit2/Retrofit;", "client", "moshi", "provideRestAdapter$PDTranslator", "PDTranslator"})
@dagger.Module()
@di.scope.PerApplication()
public final class ApiModule {
    
    @org.jetbrains.annotations.NotNull()
    @di.scope.PerApplication()
    @dagger.Provides()
    public final okhttp3.Interceptor provideInterceptor$PDTranslator() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @di.scope.PerApplication()
    @dagger.Provides()
    public final okhttp3.OkHttpClient provideOkHttp$PDTranslator(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor interceptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @di.scope.PerApplication()
    @dagger.Provides()
    public final com.squareup.moshi.Moshi provideMoshi$PDTranslator() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @di.scope.PerApplication()
    @dagger.Provides()
    public final retrofit2.Retrofit provideRestAdapter$PDTranslator(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    public ApiModule() {
        super();
    }
}