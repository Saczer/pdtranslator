package pl.olszak.michal.pdtranslator.di.module

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import pl.olszak.michal.pdtranslator.data.remote.RestService
import pl.olszak.michal.pdtranslator.di.scope.PerApplication
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * @author molszak
 * created on 28.11.2017.
 */
@PerApplication
@Module
class ApiModule {

    @Provides
    @PerApplication
    fun provideInterceptor(@Named("serviceKey") serviceKey : String): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val url = original.url()

            val newUrl = url.newBuilder()
                    .addQueryParameter("key", serviceKey)
                    .build()
            val request = original.newBuilder()
                    .url(newUrl)

            chain.proceed(request.build())
        }

    }


    @Provides
    @PerApplication
    fun provideOkHttp(interceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .addInterceptor(interceptor)

        return builder.build()
    }


    @Provides
    @PerApplication
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }


    @Provides
    @PerApplication
    fun provideRestAdapter(client: OkHttpClient, moshi: Moshi,@Named("remoteUrl") url : String): Retrofit {
        val builder = Retrofit.Builder()

        builder.client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(url)

        return builder.build()
    }

    @Provides
    @PerApplication
    fun provideRestService(adapter: Retrofit): RestService
            = adapter.create(RestService::class.java)


}