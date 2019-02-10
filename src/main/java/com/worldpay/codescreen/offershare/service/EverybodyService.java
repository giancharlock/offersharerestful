package com.worldpay.codescreen.offershare.service;

import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import com.worldpay.codescreen.offershare.pojo.Offer;

import java.util.List;

public interface EverybodyService {
    List<Offer> getAllOffers() throws GenericOfferException;
    List<Offer> getAllNotExpiredOffers() throws GenericOfferException;
}
