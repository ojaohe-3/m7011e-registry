package m7011e.the_homeric_odyssey.registry.controllers;

import m7011e.the_homeric_odyssey.registry.models.domain.ErrorMessage;
import m7011e.the_homeric_odyssey.registry.models.ResourceNotFoundException;
import m7011e.the_homeric_odyssey.registry.models.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class RegistryControllerAdvice {
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleValidationException(final ValidationException exception) {
        return exception.getErrorMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String, String> handleUserNotFoundException(ResourceNotFoundException exception) {
        return Map.of("message", exception.getMessage());
    }
}
