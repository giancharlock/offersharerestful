package com.worldpay.codescreen.offershare.dao.impl;

import com.worldpay.codescreen.offershare.pojo.Offer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public class OfferDAOImplTest extends OfferDAOImplBaseTest {

    @Test
    public void insert() {
        Offer offer = offerDAO.save(
                getOffer(1l,"myoffer", "myoffer description","EUR",
                        "123.45",new Date(new Date().getTime()+100000)));
        offerDAO.flush();
        Assert.assertTrue(offerDAO.findById(offer.getId()).isPresent());
    }

    @Test
    public void delete() {
        offerDAO.delete(offers.get(0));
        offerDAO.flush();
        Assert.assertFalse(offerDAO.findById(offers.get(0).getId()).isPresent());
    }

    @Test
    public void viewAll() {
        List<Offer> list = offerDAO.findAll();
        Assert.assertEquals(2,list.size());
        Assert.assertTrue(list.contains(offers.get(0)));
        Assert.assertTrue(list.contains(offers.get(1)));
    }

    @Test
    public void viewAllNotExpired() {
        List<Offer> list = offerDAO.findAllNotExpired(new Date());
        Assert.assertEquals(1,list.size());
        Assert.assertEquals(1l,offers.get(0).getId().longValue());
    }

}