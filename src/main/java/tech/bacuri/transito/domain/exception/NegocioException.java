package tech.bacuri.transito.domain.exception;

public class NegocioException extends RuntimeException {
    public NegocioException(String message) {
        super(message);
    }

    public NegocioException() {
        super("Alguma regra de negócio foi violada");
    }
}
