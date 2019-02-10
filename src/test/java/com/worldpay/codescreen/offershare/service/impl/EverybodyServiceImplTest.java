package com.worldpay.codescreen.offershare.service.impl;

import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import com.worldpay.codescreen.offershare.pojo.Offer;
import com.worldpay.codescreen.offershare.service.EverybodyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EverybodyServiceImplTest extends  ServiceTestBase{

    private List<Offer> offers;

    @InjectMocks
    EverybodyService everybodyService = new EverybodyServiceImpl();

    @Before
    public void setUp(){
        offers = new ArrayList<>();
        Offer offer = getOffer(1l, "myoffer1", "my offer descr 1", "EUR","77.88", new Date());
        offers.add(offer);
        offer = getOffer(2l, "myoffer2", "my offer descr 2", "EUR","99.88", new Date());
        offers.add(offer);
    }

    @Test
    public void getAllOffers1() throws GenericOfferException {
        when(offerDAO.findAll()).thenReturn(offers);
        Assert.assertEquals(offers,everybodyService.getAllOffers());
        verify(offerDAO, times(1)).findAll();
    }

    @Test(expected = GenericOfferException.class)
    public void getAllOffers2() throws GenericOfferException {
        when(offerDAO.findAll()).thenThrow();
        everybodyService.getAllOffers();
    }

    @Test
    public void getAllNotExpiredOffers1() throws GenericOfferException {
        when(offerDAO.findAllNotExpired(any(Date.class))).thenReturn(offers);
        Assert.assertEquals(offers,everybodyService.getAllNotExpiredOffers());
        verify(offerDAO, times(1)).findAllNotExpired(any(Date.class));
    }

    @Test(expected = GenericOfferException.class)
    public void getAllNotExpiredOffers2() throws GenericOfferException {
        when(offerDAO.findAllNotExpired(any(Date.class))).thenThrow();
        everybodyService.getAllNotExpiredOffers();
    }
}