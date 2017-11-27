package di.component;

import dagger.Component;
import di.module.ApplicationModule;
import di.scope.PerApplication;
import presentation.Translator;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Ldi/component/TranslationComponent;", "", "translator", "Lpresentation/Translator;", "PDTranslator"})
@dagger.Component(modules = {di.module.ApplicationModule.class})
@di.scope.PerApplication()
public abstract interface TranslationComponent {
    
    @org.jetbrains.annotations.NotNull()
    public abstract presentation.Translator translator();
}