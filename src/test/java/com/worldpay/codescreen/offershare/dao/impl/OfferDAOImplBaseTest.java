package com.worldpay.codescreen.offershare.dao.impl;

import com.worldpay.codescreen.offershare.dao.OfferDAO;
import com.worldpay.codescreen.offershare.pojo.Offer;
import org.junit.Before;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfferDAOImplBaseTest {

    List<Offer> offers = new ArrayList<>();

    @Resource
    OfferDAO offerDAO;

    @Before
    public void setUp() throws Exception {
        initDb();
        for (Offer offer: offers) {
            offerDAO.save(offer);
            offerDAO.flush();
        }
    }

    private void initDb() {
        offers.add(getOffer("first","first description",
                "EUR","12.50", new Date(new Date().getTime()+100000)));
        offers.add(getOffer("second","second description",
                "USD","24.23", new Date(new Date().getTime()-100000)));
    }

    static Offer getOffer(String title, String descr, String cur, String price, Date expireDate) {
        Offer offer = new Offer();
        offer.setCurrency(cur);
        offer.setTitle(title);
        offer.setDescription(descr);
        offer.setPrice(price!=null?new BigDecimal(price):null);
        offer.setExpireDate(expireDate);
        return offer;
    }

    public static Offer getOffer(Long id,String title, String descr, String cur, String price, Date expireDate) {
        Offer offer = getOffer(title,descr,cur,price,expireDate);
        offer.setId(id);
        return offer;
    }

}
