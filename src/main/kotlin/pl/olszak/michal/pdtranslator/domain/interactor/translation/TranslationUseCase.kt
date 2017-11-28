package pl.olszak.michal.pdtranslator.domain.interactor.translation

import pl.olszak.michal.pdtranslator.data.translation.TranslationRepository
import pl.olszak.michal.pdtranslator.domain.interactor.SingleUseCase
import io.reactivex.Single
import pl.olszak.michal.pdtranslator.model.google.TranslationApiResponse
import java.lang.IllegalArgumentException
import javax.inject.Inject

/**
 * @author molszak
 * created on 27.11.2017.
 */
class TranslationUseCase @Inject constructor(
        private val repository: TranslationRepository)
    : SingleUseCase<TranslationApiResponse, String>() {


    override fun buildObservable(params: String?): Single<TranslationApiResponse> {
        if(!params.isNullOrEmpty()){
            return repository.getPolishTranslation(params.orEmpty())
        }
        throw IllegalArgumentException("no text entered to translate")
    }
}