package com.worldpay.codescreen.offershare.pojo;

import com.worldpay.codescreen.offershare.dao.impl.OfferDAOImplBaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OfferTest {

    private void fill(Offer offer, Long id, String title, String description, BigDecimal price, String cur, Date date) {
        offer.setId(id);
        offer.setTitle(title);
        offer.setDescription(description);
        offer.setPrice(price);
        offer.setCurrency(cur);
        offer.setExpireDate(date);
    }

    @Test
    public void allInOneGetSetTest() {
        Date d1 = new Date();
        Offer offer = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Assert.assertEquals(new Long(1), offer.getId());
        Assert.assertEquals("title",offer.getTitle());
        Assert.assertEquals("title descr", offer.getDescription());
        Assert.assertEquals("EUR", offer.getCurrency());
        Assert.assertEquals(d1, offer.getExpireDate());
        Assert.assertEquals(d1, offer.getExpireDate());
    }

    @Test
    public void setExpireDate1() {
        Offer o1 = new Offer();
        o1.setExpireDate(new Date(new Date().getTime()+10000));
        Assert.assertFalse(o1.isExpired());
    }

    @Test
    public void setExpireDate2() {
        Offer o1 = new Offer();
        o1.setExpireDate(new Date(new Date().getTime()-10000));
        Assert.assertTrue(o1.isExpired());
    }

    @Test
    public void equalsTest1() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Assert.assertTrue(offerA.equals(offerB));
    }

    @Test
    public void equalsTest2() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(2),"title","title descr","EUR","12.50",d1);
        Assert.assertFalse(offerA.equals(offerB));
    }

    @Test
    public void equalsTest3() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"titl","title descr","EUR","12.50",d1);
        Assert.assertFalse(offerA.equals(offerB));
    }

    @Test
    public void equalsTest4() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descri","EUR","12.50",d1);
        Assert.assertFalse(offerA.equals(offerB));
    }

    @Test
    public void equalsTest5() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","USD","12.50",d1);
        Assert.assertFalse(offerA.equals(offerB));
    }

    @Test
    public void equalsTest6() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.51",d1);
        Assert.assertFalse(offerA.equals(offerB));
    }

    @Test
    public void equalsTest7() {
        Date d1 = new Date();
        Date d2 = new Date(d1.getTime()+1000);
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d2);
        Assert.assertFalse(offerA.equals(offerB));
    }

    @Test
    public void hashCodeTest() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Assert.assertTrue(offerA.hashCode()==offerB.hashCode());
    }

    @Test
    public void hashCodeTest1() {
        Date d1 = new Date();
        Date d2 = new Date(d1.getTime()+1000);
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d2);
        Assert.assertTrue(offerA.hashCode()!=offerB.hashCode());
    }

    @Test
    public void hashCodeTest2() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(2),"title","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Assert.assertTrue(offerA.hashCode()!=offerB.hashCode());
    }

    @Test
    public void hashCodeTest3() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"titles","title descr","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Assert.assertTrue(offerA.hashCode()!=offerB.hashCode());
    }

    @Test
    public void hashCodeTest4() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title description","EUR","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Assert.assertTrue(offerA.hashCode()!=offerB.hashCode());
    }

    @Test
    public void hashCodeTest5() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","USD","12.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Assert.assertTrue(offerA.hashCode()!=offerB.hashCode());
    }

    @Test
    public void hashCodeTest6() {
        Date d1 = new Date();
        Offer offerA = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","10.50",d1);
        Offer offerB = OfferDAOImplBaseTest.getOffer(new Long(1),"title","title descr","EUR","12.50",d1);
        Assert.assertTrue(offerA.hashCode()!=offerB.hashCode());
    }

}