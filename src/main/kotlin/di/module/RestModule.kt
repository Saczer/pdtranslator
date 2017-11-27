package di.module

import dagger.Module
import dagger.Provides
import data.RestService
import di.scope.PerApplication
import retrofit2.Retrofit

/**
 * @author molszak
 * created on 27.11.2017.
 */
@PerApplication
@Module(includes = arrayOf(ApiModule::class))
class RestModule {

    @Provides
    @PerApplication
    internal fun provideRestService(adapter: Retrofit): RestService
            = adapter.create(RestService::class.java)

}