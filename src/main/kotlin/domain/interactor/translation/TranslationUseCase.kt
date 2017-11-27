package domain.interactor.translation

import data.translation.TranslationRepository
import domain.interactor.SingleUseCase
import io.reactivex.Single
import model.google.TranslationApiResponse
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