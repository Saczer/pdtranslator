package pl.olszak.michal.pdtranslator.domain.interactor.extraction

import io.reactivex.Single
import pl.olszak.michal.pdtranslator.domain.extractor.FileTextExtractor
import pl.olszak.michal.pdtranslator.domain.interactor.SingleUseCase
import java.io.File
import javax.inject.Inject

/**
 * @author molszak
 * created on 30.11.2017.
 */
class ExtractTextFromFile @Inject constructor(
        private val extractor : FileTextExtractor): SingleUseCase<List<String>, String>() {

    override fun buildObservable(params: String?): Single<List<String>> {
        if(!params.isNullOrBlank()){
            val file = File(params)
            if (file.exists()) {
                return extractor.transform(file)
            }
        }
        return Single.just(emptyList())
    }

}