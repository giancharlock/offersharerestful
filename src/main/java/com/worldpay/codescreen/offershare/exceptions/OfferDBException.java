package com.worldpay.codescreen.offershare.exceptions;

public class OfferDBException extends Exception  {
    public OfferDBException(String errMsg, Throwable ex) {
        super(errMsg,ex);
    }
}
