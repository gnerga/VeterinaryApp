package pl.gr.veterinaryapp.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.gr.veterinaryapp.exception.IncorrectDataException;
import pl.gr.veterinaryapp.exception.ResourceNotFoundException;

@ControllerAdvice
@Slf4j
public class VetExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = IncorrectDataException.class)
    protected ResponseEntity<Object> incorrectData(
            IncorrectDataException ex, WebRequest request) {
        logError(ex.getMessage(), "IncorrectDataException");
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value
            = ResourceNotFoundException.class)
    protected ResponseEntity<Object> resourceNotFound(
            ResourceNotFoundException ex, WebRequest request) {
        logError(ex.getMessage(), "ResourceNotFoundException");
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    private void logError(String message, String exceptionType) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error: ");
        sb.append(exceptionType);
        sb.append(" - ");
        sb.append(message);
        log.error(sb.toString());
    }

}
