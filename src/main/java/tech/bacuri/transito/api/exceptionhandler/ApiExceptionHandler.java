package tech.bacuri.transito.api.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.bacuri.transito.domain.exception.NegocioException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Map<String, String>> capturar(NegocioException e) {
        Map<String, String> body = new HashMap<>();
        body.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(body);
    }
}
