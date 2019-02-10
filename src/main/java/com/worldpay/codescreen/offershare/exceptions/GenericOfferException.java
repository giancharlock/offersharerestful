package com.worldpay.codescreen.offershare.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericOfferException extends Exception  {
    public GenericOfferException(String errMsg, Throwable ex) {
        super(errMsg,ex);
    }

    public GenericOfferException(String errMsg) {
        super(errMsg);
    }
}
