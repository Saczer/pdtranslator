package pl.olszak.michal.pdtranslator.model.api

/**
 * @author molszak
 * created on 27.11.2017.
 */
class Response<out T> constructor(val status: Status, val data: T?, val throwable: Throwable?) {

    companion object {
        fun <T> success(data: T): Response<T> = Response(Status.SUCCESS, data, null)

        fun <T> error(throwable: Throwable): Response<T> = Response(Status.ERROR, null, throwable)
    }
}