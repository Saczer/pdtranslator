package pl.olszak.michal.pdtranslator.domain.interactor.translation

import io.reactivex.Single
import pl.olszak.michal.pdtranslator.domain.interactor.SingleUseCase
import pl.olszak.michal.pdtranslator.model.google.TranslatedTextResponseList
import pl.olszak.michal.pdtranslator.model.google.TranslatedTextResponseTranslation
import pl.olszak.michal.pdtranslator.model.google.TranslationApiResponse
import javax.inject.Inject

/**
 * @author molszak
 * created on 28.11.2017.
 */
class StubTranslationUseCase @Inject constructor() : SingleUseCase<TranslationApiResponse, String>()  {

    override fun buildObservable(params: String?): Single<TranslationApiResponse> {
        return Single.just(TranslationApiResponse(TranslatedTextResponseList(listOf(TranslatedTextResponseTranslation(params.orEmpty())))))
    }

}