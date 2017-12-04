package pl.olszak.michal.pdtranslator.domain.collector

import io.reactivex.Single
import pl.olszak.michal.pdtranslator.model.collect.FileData
import java.io.File

interface FileResultCollector {

    fun collect(data : FileData) : Single<File>

}