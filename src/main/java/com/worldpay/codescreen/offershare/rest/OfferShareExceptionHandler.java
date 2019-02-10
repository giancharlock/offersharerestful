package com.worldpay.codescreen.offershare.rest;

import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class OfferShareExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GenericOfferException.class)
    public final ResponseEntity<String> catchExceptions(GenericOfferException ex, WebRequest req){
        String errMsg = ex.getMessage()+req.getDescription(false);
        return new ResponseEntity<>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest req) {
        String errMsg = ex.getMessage()+req.getDescription(false);
        return new ResponseEntity<>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
