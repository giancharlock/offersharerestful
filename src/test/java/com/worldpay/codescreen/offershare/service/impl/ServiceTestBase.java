package com.worldpay.codescreen.offershare.service.impl;

import com.worldpay.codescreen.offershare.dao.OfferDAO;
import com.worldpay.codescreen.offershare.dao.impl.OfferDAOImplBaseTest;
import com.worldpay.codescreen.offershare.pojo.Offer;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public abstract class ServiceTestBase {

    @Mock
    OfferDAO offerDAO;

    public static Offer getOffer(Long id, String title, String descr, String cur, String price, Date expireDate) {
        return OfferDAOImplBaseTest.getOffer(id,title,descr,cur,price,expireDate);
    }
}
