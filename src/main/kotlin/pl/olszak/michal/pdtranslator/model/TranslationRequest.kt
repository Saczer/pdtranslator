package pl.olszak.michal.pdtranslator.model

/**
 * @author molszak
 * created on 27.11.2017.
 */
data class TranslationRequest(
        val toTranslate: String,
        val sourceLanguage: Language,
        val targetLanguage: Language)