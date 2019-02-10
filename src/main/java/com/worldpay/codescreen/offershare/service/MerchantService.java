package com.worldpay.codescreen.offershare.service;

import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import com.worldpay.codescreen.offershare.pojo.Offer;

public interface MerchantService {
    void insertOffer(Offer offer) throws GenericOfferException;
    void deleteOffer(Long id) throws GenericOfferException;
}
