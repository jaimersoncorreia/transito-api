package tech.bacuri.transito.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException{
    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
