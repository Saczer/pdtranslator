package domain.interactor

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author molszak
 * created on 27.11.2017.
 */
abstract class SingleUseCase<T, in Params> {

    private val disposables = CompositeDisposable()

    protected abstract fun buildObservable(params: Params? = null): Single<T>

    open fun execute(
            singleObserver: DisposableSingleObserver<T>,
            params: Params? = null) {

        val single = buildObservable(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.single()) as Single<T>

        addDisposable(single.subscribeWith(singleObserver))
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

}