package com.worldpay.codescreen.offershare.service.impl;

import com.worldpay.codescreen.offershare.dao.OfferDAO;
import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import com.worldpay.codescreen.offershare.pojo.Offer;
import com.worldpay.codescreen.offershare.service.EverybodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = {GenericOfferException.class})
public class EverybodyServiceImpl implements EverybodyService {

    @Autowired
    private OfferDAO offerDAO;

    @Override
    public List<Offer> getAllOffers() throws GenericOfferException {
        try{
            return offerDAO.findAll();
        }catch (Exception e){
            throw new GenericOfferException("error getting all offers: "+e.getMessage(),e);
        }
    }

    @Override
    public List<Offer> getAllNotExpiredOffers() throws GenericOfferException {
        try{
            return offerDAO.findAllNotExpired(new Date());
        }catch (Exception e){
            throw new GenericOfferException("error getting all not expired offers: "+e.getMessage(),e);
        }
    }
}
