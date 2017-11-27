package data.translation;

import data.RestService;
import io.reactivex.Single;
import model.Language;
import model.TranslationRequest;
import model.google.TranslationApiResponse;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Ldata/translation/RestTranslationRepository;", "Ldata/translation/TranslationRepository;", "service", "Ldata/RestService;", "(Ldata/RestService;)V", "getPolishTranslation", "Lio/reactivex/Single;", "Lmodel/google/TranslationApiResponse;", "text", "", "PDTranslator"})
public final class RestTranslationRepository implements data.translation.TranslationRepository {
    private final data.RestService service = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<model.google.TranslationApiResponse> getPolishTranslation(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
    
    @javax.inject.Inject()
    public RestTranslationRepository(@org.jetbrains.annotations.NotNull()
    data.RestService service) {
        super();
    }
}