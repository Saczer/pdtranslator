package domain.interactor;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00002\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00018\u0001H$\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\'\u0010\u0010\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\n\b\u0002\u0010\r\u001a\u0004\u0018\u00018\u0001H\u0016\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Ldomain/interactor/SingleUseCase;", "T", "Params", "", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "addDisposable", "", "disposable", "Lio/reactivex/disposables/Disposable;", "buildObservable", "Lio/reactivex/Single;", "params", "(Ljava/lang/Object;)Lio/reactivex/Single;", "dispose", "execute", "singleObserver", "Lio/reactivex/observers/DisposableSingleObserver;", "(Lio/reactivex/observers/DisposableSingleObserver;Ljava/lang/Object;)V", "PDTranslator"})
public abstract class SingleUseCase<T extends java.lang.Object, Params extends java.lang.Object> {
    private final io.reactivex.disposables.CompositeDisposable disposables = null;
    
    @org.jetbrains.annotations.NotNull()
    protected abstract io.reactivex.Single<T> buildObservable(@org.jetbrains.annotations.Nullable()
    Params params);
    
    public void execute(@org.jetbrains.annotations.NotNull()
    io.reactivex.observers.DisposableSingleObserver<T> singleObserver, @org.jetbrains.annotations.Nullable()
    Params params) {
    }
    
    public final void dispose() {
    }
    
    private final void addDisposable(io.reactivex.disposables.Disposable disposable) {
    }
    
    public SingleUseCase() {
        super();
    }
}