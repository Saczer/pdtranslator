package pl.olszak.michal.pdtranslator.domain.collector.text

import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import pl.olszak.michal.pdtranslator.domain.collector.FileResultCollector
import pl.olszak.michal.pdtranslator.model.collect.FileData
import java.io.*
import javax.inject.Inject

class TextFileResultCollector @Inject constructor() : FileResultCollector {

    override fun collect(data: FileData): Single<File> {
        return Single.create(Collector(data))
    }

    private class Collector constructor(private val data: FileData) : SingleOnSubscribe<File> {

        override fun subscribe(emitter: SingleEmitter<File>) {
            if (data.filePath.isEmpty() || data.fileName.isEmpty()) {
                emitter.onError(IOException("File path and name should not be empty"))
            }
            val file = File(data.filePath, data.fileName + FILE_EXTENSION)
            if (!file.exists() || !file.parentFile.exists()) {
                file.parentFile.mkdirs()
            }

            try {

                FileOutputStream(file).use { stream ->
                    stream.write(data.content.toByteArray())
                }
            } catch (e: FileNotFoundException) {
                emitter.onError(IOException("Error while creating file ${data.filePath}\\${data.fileName}$FILE_EXTENSION", e))
            }
            emitter.onSuccess(file)
        }

        companion object {
            const val FILE_EXTENSION = ".txt"
        }

    }

}