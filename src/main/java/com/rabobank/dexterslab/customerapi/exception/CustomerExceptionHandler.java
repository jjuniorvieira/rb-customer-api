package com.rabobank.dexterslab.customerapi.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.Constraint;
import javax.validation.ConstraintViolationException;
import static com.rabobank.dexterslab.customerapi.utils.ResponseUtil.setErrorMessage;

@ControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ExceptionUtils.getRootCauseMessage(ex).split("at \\[Source")[0], HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(setErrorMessage(ex.getBindingResult()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<Object> handleGeneralError(ConstraintViolationException ex) {
        return new ResponseEntity<>(ExceptionUtils.getRootCauseMessage(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handleGeneralError(DataIntegrityViolationException ex) {
        return new ResponseEntity<>("First Name and Last Name already exist in our database.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    protected ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex) {
        return new ResponseEntity<>(ExceptionUtils.getRootCauseMessage(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleGeneralError(Exception ex) {
        return new ResponseEntity<>(ExceptionUtils.getRootCauseMessage(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
