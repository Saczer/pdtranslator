package di.module

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import data.Constants
import di.scope.PerApplication
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author molszak
 * created on 27.11.2017.
 */
@PerApplication
@Module
class ApiModule {


    @Provides
    @PerApplication
    internal fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val url = original.url()

            val newUrl = url.newBuilder()
                    .addQueryParameter("key", Constants.API_KEY)
                    .build()
            val request = original.newBuilder()
                    .url(newUrl)

            chain.proceed(request.build())
        }

    }


    @Provides
    @PerApplication
    internal fun provideOkHttp(interceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .addInterceptor(interceptor)

        return builder.build()
    }


    @Provides
    @PerApplication
    internal fun provideMoshi() : Moshi{
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }


    @Provides
    @PerApplication
    internal fun provideRestAdapter(client: OkHttpClient, moshi: Moshi) : Retrofit{
        val builder = Retrofit.Builder()

        builder.client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(Constants.URL)

        return builder.build()
    }
}