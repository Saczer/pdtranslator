package di.module;

import dagger.Module;
import dagger.Provides;
import data.RestService;
import di.scope.PerApplication;
import retrofit2.Retrofit;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Ldi/module/RestModule;", "", "()V", "provideRestService", "Ldata/RestService;", "adapter", "Lretrofit2/Retrofit;", "provideRestService$PDTranslator", "PDTranslator"})
@dagger.Module()
@di.scope.PerApplication()
public final class RestModule {
    
    @org.jetbrains.annotations.NotNull()
    @di.scope.PerApplication()
    @dagger.Provides()
    public final data.RestService provideRestService$PDTranslator(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit adapter) {
        return null;
    }
    
    public RestModule() {
        super();
    }
}