package com.worldpay.codescreen.offershare.service.impl;

import com.worldpay.codescreen.offershare.dao.OfferDAO;
import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import com.worldpay.codescreen.offershare.pojo.Offer;
import com.worldpay.codescreen.offershare.rest.OfferShareExceptionHandler;
import com.worldpay.codescreen.offershare.service.MerchantService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(rollbackFor = {GenericOfferException.class})
public class MerchantServiceImpl implements MerchantService {

    private static Logger log = LoggerFactory.getLogger(OfferShareExceptionHandler.class);

    @Autowired
    private OfferDAO offerDAO;

    @Override
    public void insertOffer(Offer offer) throws GenericOfferException {
        try {
            log.debug("Add offer:"+offer.toString());
            offerDAO.save(offer);

        }catch (Exception e){
            throw new GenericOfferException("Error saving offer: "+offer.toString(),e);
        }
    }

    @Override
    public void deleteOffer(Long id) throws GenericOfferException {
        try {
            Optional<Offer> optOffer = offerDAO.findById(id);
            if(optOffer.isPresent()) {
                Offer offer = optOffer.get();
                offerDAO.delete(offer);
            }else {
                throw new GenericOfferException("Offer not found for id: "+id);
            }
        }catch (Exception e){
            throw new GenericOfferException("Error removing offer: "+e.getMessage(),e);
        }
    }
}
