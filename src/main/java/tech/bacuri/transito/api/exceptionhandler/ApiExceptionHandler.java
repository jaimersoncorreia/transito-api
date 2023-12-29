package tech.bacuri.transito.api.exceptionhandler;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.bacuri.transito.domain.exception.NegocioException;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle("Um ou mais campos estão inválidos");
        problemDetail.setType(URI.create("http://localhost:8080/erros"));

        Map<String, String> fields = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> (FieldError) objectError)
                .collect(Collectors.toMap(FieldError::getField, fe -> messageSource.getMessage(fe, LocaleContextHolder.getLocale())));

        problemDetail.setProperty("fields", fields);

        return handleExceptionInternal(ex, problemDetail, headers, status, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Map<String, String>> capturar(NegocioException e) {
        Map<String, String> body = new HashMap<>();
        body.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(body);
    }
}
