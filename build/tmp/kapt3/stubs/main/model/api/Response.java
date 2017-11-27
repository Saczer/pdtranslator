package model.api;

@kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\u0018\u0000 \u0010*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0010B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lmodel/api/Response;", "T", "", "status", "Lmodel/api/Status;", "data", "throwable", "", "(Lmodel/api/Status;Ljava/lang/Object;Ljava/lang/Throwable;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStatus", "()Lmodel/api/Status;", "getThrowable", "()Ljava/lang/Throwable;", "Companion", "PDTranslator"})
public final class Response<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    private final model.api.Status status = null;
    @org.jetbrains.annotations.Nullable()
    private final T data = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Throwable throwable = null;
    public static final model.api.Response.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final model.api.Status getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T getData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Throwable getThrowable() {
        return null;
    }
    
    public Response(@org.jetbrains.annotations.NotNull()
    model.api.Status status, @org.jetbrains.annotations.Nullable()
    T data, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable throwable) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 8}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\t\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lmodel/api/Response$Companion;", "", "()V", "error", "Lmodel/api/Response;", "T", "throwable", "", "success", "data", "(Ljava/lang/Object;)Lmodel/api/Response;", "PDTranslator"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>model.api.Response<T> success(T data) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>model.api.Response<T> error(@org.jetbrains.annotations.NotNull()
        java.lang.Throwable throwable) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}