package app.handlers;

import app.models.ExceptionResponse;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CurrencyExceptionHandler {

    @ExceptionHandler(value = FeignException.class)
    public ExceptionResponse handleFeignException(FeignException exception) {
        return new ExceptionResponse(HttpStatus.FORBIDDEN.value(), exception.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ExceptionResponse handleOtherRuntimeExceptions(RuntimeException exception) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());
    }
}
