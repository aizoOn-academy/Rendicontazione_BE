package com.aizoon.rendicontazione.error.handlers;

import com.aizoon.rendicontazione.error.ValidationErrorDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
    protected static Logger logger = LoggerFactory.getLogger(ValidationExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        ValidationErrorDetails errorDetails = new ValidationErrorDetails("Request validation error",
                request.getDescription(false), allErrors)

        ;
        logger.error(String.format(
                "MethodArgumentNotValidException :: fieldErrors=%s :: genericErrors=%s",
                errorDetails.getFieldErrors(), errorDetails.getGenericErrors()));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}