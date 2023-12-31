package tech.bacuri.transito.domain.exception;

public class ConflitoDeAtualizacaoException extends NegocioException{
    public ConflitoDeAtualizacaoException(String message) {
        super(message);
    }
}
