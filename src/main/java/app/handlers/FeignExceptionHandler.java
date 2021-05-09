package app.handlers;

import app.models.ExceptionResponse;
import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(value = FeignException.class)
    public ExceptionResponse handleTheException(FeignException exception) {
        return new ExceptionResponse(exception.status(),
                exception.getMessage(),
                LocalDateTime.now());
    }
}
