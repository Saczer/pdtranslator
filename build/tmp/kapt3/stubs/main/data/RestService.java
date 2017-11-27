package data;

import io.reactivex.Single;
import model.google.TranslationApiResponse;
import retrofit2.http.POST;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H\'\u00a8\u0006\n"}, d2 = {"Ldata/RestService;", "", "translate", "Lio/reactivex/Single;", "Lmodel/google/TranslationApiResponse;", "translationText", "", "targetLanguage", "format", "sourceLanguage", "PDTranslator"})
public abstract interface RestService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/language/translate/v2")
    public abstract io.reactivex.Single<model.google.TranslationApiResponse> translate(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String translationText, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "target")
    java.lang.String targetLanguage, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "format")
    java.lang.String format, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "source")
    java.lang.String sourceLanguage);
}