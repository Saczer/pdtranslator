package presentation;

import io.reactivex.Observable;
import model.api.Response;
import java.io.File;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lpresentation/Translator;", "", "getTranslation", "Lio/reactivex/Observable;", "Lmodel/api/Response;", "", "translate", "", "input", "Ljava/io/File;", "text", "PDTranslator"})
public abstract interface Translator {
    
    public abstract void translate(@org.jetbrains.annotations.NotNull()
    java.lang.String text);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<model.api.Response<java.lang.String>> getTranslation();
    
    public abstract void translate(@org.jetbrains.annotations.NotNull()
    java.io.File input);
}