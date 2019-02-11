package com.worldpay.codescreen.offershare.rest;

import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class OfferShareExceptionHandler extends ResponseEntityExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(OfferShareExceptionHandler.class);

    @ExceptionHandler(GenericOfferException.class)
    public final ResponseEntity<String> catchExceptions(GenericOfferException ex, WebRequest req){
        String errMsg = ex.getMessage()+req.getDescription(false);
        log.error("Catched GenericOfferException:"+errMsg);
        return new ResponseEntity<>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest req) {
        String errMsg = ex.getClass().getName()+": "+ex.getMessage()+req.getDescription(false);
        log.error("Catched exception:"+errMsg);
        return new ResponseEntity<>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
