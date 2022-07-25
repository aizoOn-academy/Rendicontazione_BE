package com.aizoon.rendicontazione.error;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidationErrorDetails extends ErrorDetails {

    private Map<String, String> fieldErrors;
    private List<String> genericErrors;

    public ValidationErrorDetails() {
        super();
    }

    public ValidationErrorDetails(String message, String details, List<ObjectError> errors) {
        super(message, details);
        this.fieldErrors = errors.stream()
                .filter(err -> err instanceof FieldError)
                .collect(Collectors.toMap(err -> ((FieldError) err).getField(), err -> err.getDefaultMessage()));

        this.genericErrors = errors.stream()
                .filter(err -> !(err instanceof FieldError))
                .map(err -> err.getDefaultMessage())
                .toList();
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public List<String> getGenericErrors() {
        return genericErrors;
    }

    public void setGenericErrors(List<String> genericErrors) {
        this.genericErrors = genericErrors;
    }

}
