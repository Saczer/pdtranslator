package pl.olszak.michal.pdtranslator.domain.interactor.translation

import io.reactivex.Single
import pl.olszak.michal.pdtranslator.data.TranslationRepository
import pl.olszak.michal.pdtranslator.domain.interactor.SingleUseCase
import pl.olszak.michal.pdtranslator.model.google.TranslationApiResponse
import javax.inject.Inject

/**
 * @author molszak
 * created on 27.11.2017.
 */
class TranslateText @Inject constructor(
        private val repository: TranslationRepository)
    : SingleUseCase<TranslationApiResponse, String>() {

    override fun buildObservable(params: String?): Single<TranslationApiResponse> {
        return repository.getPolishTranslation(params.orEmpty())
    }

}