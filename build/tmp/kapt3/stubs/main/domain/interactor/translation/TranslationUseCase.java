package domain.interactor.translation;

import data.translation.TranslationRepository;
import domain.interactor.SingleUseCase;
import io.reactivex.Single;
import model.google.TranslationApiResponse;
import java.lang.IllegalArgumentException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Ldomain/interactor/translation/TranslationUseCase;", "Ldomain/interactor/SingleUseCase;", "Lmodel/google/TranslationApiResponse;", "", "repository", "Ldata/translation/TranslationRepository;", "(Ldata/translation/TranslationRepository;)V", "buildObservable", "Lio/reactivex/Single;", "params", "PDTranslator"})
public final class TranslationUseCase extends domain.interactor.SingleUseCase<model.google.TranslationApiResponse, java.lang.String> {
    private final data.translation.TranslationRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected io.reactivex.Single<model.google.TranslationApiResponse> buildObservable(@org.jetbrains.annotations.Nullable()
    java.lang.String params) {
        return null;
    }
    
    @javax.inject.Inject()
    public TranslationUseCase(@org.jetbrains.annotations.NotNull()
    data.translation.TranslationRepository repository) {
        super();
    }
}