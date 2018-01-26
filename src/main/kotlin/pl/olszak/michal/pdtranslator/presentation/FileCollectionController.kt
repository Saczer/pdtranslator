package pl.olszak.michal.pdtranslator.presentation

import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import pl.olszak.michal.pdtranslator.domain.interactor.translation.CollectToFile
import pl.olszak.michal.pdtranslator.model.collect.FileData
import pl.olszak.michal.pdtranslator.model.remote.Response
import pl.olszak.michal.pdtranslator.model.remote.Status
import pl.olszak.michal.pdtranslator.util.TextUtils
import java.io.File
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

class FileCollectionController @Inject constructor(private val collectToFile: CollectToFile) : DisposableObserver<Response<String>>() {

    private var counter : AtomicInteger = AtomicInteger(0)

    override fun onError(t: Throwable) {
        println(t.localizedMessage)
    }

    override fun onNext(response: Response<String>) {
        when (response.status) {
            Status.ERROR -> {
                if (response.throwable != null) {
                    println(response.throwable.localizedMessage)
                }
            }
            Status.SUCCESS -> {
                if (response.data != null && response.data.isNotEmpty()) {
                    val translated = TextUtils.createUserReadableString(response.data)

                    val data = FileData(counter.get().toString(), TRANSLATION_FOLDER, translated)
                    collectToFile.execute(object : DisposableSingleObserver<File>() {
                        override fun onError(throwable: Throwable) {
                            println("this error should not happen")
                            println(throwable.localizedMessage)
                        }

                        override fun onSuccess(file: File) {
                            println("Created translation ${file.absolutePath}")
                        }
                    }, data)
                }
            }
        }
        counter.incrementAndGet()
    }

    override fun onComplete() {
        println("File collection completed")
    }

    private companion object {
        const val TRANSLATION_FOLDER = ".\\translations"
    }

}