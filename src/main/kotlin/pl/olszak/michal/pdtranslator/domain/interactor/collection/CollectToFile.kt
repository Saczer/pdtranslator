package pl.olszak.michal.pdtranslator.domain.interactor.collection

import io.reactivex.Single
import pl.olszak.michal.pdtranslator.domain.collector.FileResultCollector
import pl.olszak.michal.pdtranslator.domain.interactor.SingleUseCase
import pl.olszak.michal.pdtranslator.model.collect.FileData
import java.io.File
import javax.inject.Inject

class CollectToFile @Inject constructor(
        private val fileResultCollector: FileResultCollector) : SingleUseCase<File, FileData>() {

    override fun buildObservable(params: FileData?): Single<File> {
        if(params != null){
            return fileResultCollector.collect(params)
        }
        return Single.just(null)
    }

}