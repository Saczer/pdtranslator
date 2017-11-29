package pl.olszak.michal.pdtranslator.domain.interactor

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author molszak
 * created on 29.11.2017.
 */
abstract class ObservableUseCase<T, in Params> {

    private val disposables = CompositeDisposable()

    protected abstract fun buildObservable(params: Params? = null): Observable<T>

    open fun execute(observer: DisposableObserver<T>,
                     params: Params? = null) {

        val single = buildObservable(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.single())

        addDisposable(single.subscribeWith(observer))
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}