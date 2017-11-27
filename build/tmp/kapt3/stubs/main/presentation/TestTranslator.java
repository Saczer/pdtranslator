package presentation;

import domain.interactor.translation.TranslationUseCase;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.subjects.PublishSubject;
import model.api.Response;
import model.google.TranslationApiResponse;
import java.io.File;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lpresentation/TestTranslator;", "Lpresentation/Translator;", "translationUseCase", "Ldomain/interactor/translation/TranslationUseCase;", "(Ldomain/interactor/translation/TranslationUseCase;)V", "subject", "Lio/reactivex/subjects/PublishSubject;", "Lmodel/api/Response;", "", "getTranslation", "Lio/reactivex/Observable;", "translate", "", "input", "Ljava/io/File;", "text", "PDTranslator"})
public final class TestTranslator implements presentation.Translator {
    private final io.reactivex.subjects.PublishSubject<model.api.Response<java.lang.String>> subject = null;
    private final domain.interactor.translation.TranslationUseCase translationUseCase = null;
    
    @java.lang.Override()
    public void translate(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<model.api.Response<java.lang.String>> getTranslation() {
        return null;
    }
    
    @java.lang.Override()
    public void translate(@org.jetbrains.annotations.NotNull()
    java.io.File input) {
    }
    
    @javax.inject.Inject()
    public TestTranslator(@org.jetbrains.annotations.NotNull()
    domain.interactor.translation.TranslationUseCase translationUseCase) {
        super();
    }
}