package pl.olszak.michal.pdtranslator.domain.interactor.collection

import io.reactivex.Single
import pl.olszak.michal.pdtranslator.domain.collector.FileResultCollector
import pl.olszak.michal.pdtranslator.domain.interactor.SingleUseCase
import java.io.File
import javax.inject.Inject

class CollectToFile @Inject constructor(
        private val fileResultCollector: FileResultCollector) : SingleUseCase<File, String>() {

    override fun buildObservable(params: String?): Single<File> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}