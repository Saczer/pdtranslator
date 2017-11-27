package data.translation;

import io.reactivex.Single;
import model.google.TranslationApiResponse;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Ldata/translation/TranslationRepository;", "", "getPolishTranslation", "Lio/reactivex/Single;", "Lmodel/google/TranslationApiResponse;", "text", "", "PDTranslator"})
public abstract interface TranslationRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<model.google.TranslationApiResponse> getPolishTranslation(@org.jetbrains.annotations.NotNull()
    java.lang.String text);
}