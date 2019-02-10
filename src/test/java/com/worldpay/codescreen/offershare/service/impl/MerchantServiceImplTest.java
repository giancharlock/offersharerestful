package com.worldpay.codescreen.offershare.service.impl;

import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import com.worldpay.codescreen.offershare.pojo.Offer;
import com.worldpay.codescreen.offershare.service.MerchantService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Date;

import static org.mockito.Mockito.*;

public class MerchantServiceImplTest extends ServiceTestBase{

    private Offer offer;

    @InjectMocks
    MerchantService merchantService = new MerchantServiceImpl();

    @Before
    public void setUp(){
        offer = getOffer(1l, "myoffer1", "my offer descr 1", "EUR","77.88", new Date());
    }

    @Test
    public void insertOffer1() throws GenericOfferException {
        merchantService.insertOffer(offer);
        verify(offerDAO, times(1)).save(offer);
    }

    @Test(expected = GenericOfferException.class)
    public void insertOffer2() throws GenericOfferException {
        when(offerDAO.save(offer)).thenThrow();
        merchantService.insertOffer(offer);
    }

    @Test
    public void deleteOffer1() throws GenericOfferException {
        when(offerDAO.findById(offer.getId())).thenReturn(java.util.Optional.ofNullable(offer));
        merchantService.deleteOffer(offer.getId());
        verify(offerDAO, times(1)).delete(offer);
    }

    @Test(expected = GenericOfferException.class)
    public void deleteOffer2() throws GenericOfferException {
        merchantService.deleteOffer(offer.getId());
        doThrow(Exception.class).when(offerDAO).delete(offer);
    }
}