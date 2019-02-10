package com.worldpay.codescreen.offershare.dao.impl;

import com.worldpay.codescreen.offershare.pojo.Offer;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
public class OfferDAOImplTestEmptyFields extends OfferDAOImplBaseTest {

    @Test(expected = DataIntegrityViolationException.class)
    public void insert1() {
       Offer offer = offerDAO.save(
                getOffer(null, "myoffer description","EUR",
                        "123.45",new Date()));
       offerDAO.flush();
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void insert2() {
        Offer offer = offerDAO.save(
                getOffer("myoffer", null,"EUR",
                        "123.45",new Date()));
        offerDAO.flush();
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void insert3() {
        Offer offer = offerDAO.save(
                getOffer("myoffer", "myoffer description",null,
                        "123.45",new Date()));
        offerDAO.flush();
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void insert4() {
        Offer offer = offerDAO.save(
                getOffer("myoffer", "myoffer description","EUR",
                        null,new Date()));
        offerDAO.flush();
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void insert5() {
        Offer offer = offerDAO.save(
                getOffer("myoffer", "myoffer description","EUR",
                        "123.45",null));
        offerDAO.flush();
    }

}