package com.worldpay.codescreen.offershare.rest;

import com.worldpay.codescreen.offershare.dao.impl.OfferDAOImplBaseTest;
import com.worldpay.codescreen.offershare.pojo.Offer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class OfferDTOTest {

    private OfferDTO dto;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Before
    public void setUp() throws ParseException{
        dto = new OfferDTO();
        fill(dto,1l,"title","title descr",new BigDecimal("12.50"),"EUR",sdf.parse("2023-12-12 12:12"));
    }

    @Test
    public void allInOneGetSetTest() {
        Assert.assertEquals(new Long(1), dto.getId());
        Assert.assertEquals("title",dto.getTitle());
        Assert.assertEquals("title descr", dto.getDescription());
        Assert.assertEquals("EUR", dto.getCurrency());
        Assert.assertEquals("12.50", dto.getPrice().toString());
        Assert.assertEquals("2023-12-12 12:12", sdf.format(dto.getExpireDate()));
    }

    @Test
    public void getOfferEntityTest() {
        Offer offer = dto.getOfferEntity();
        Assert.assertEquals(new Long(1), offer.getId());
        Assert.assertEquals("title",offer.getTitle());
        Assert.assertEquals("title descr", offer.getDescription());
        Assert.assertEquals("EUR", offer.getCurrency());
        Assert.assertEquals("12.50", offer.getPrice().toString());
        Assert.assertEquals("2023-12-12 12:12", sdf.format(offer.getExpireDate()));
    }

    @Test
    public void toStringTest() {
        String tobe = "OfferDTO{id=1, title='title', description='title descr', currency='EUR', price=12.50, expireDate=Tue Dec 12 12:12:00 CET 2023}";
        Assert.assertEquals(tobe,dto.toString());
    }

    private void fill(OfferDTO offer, Long id, String title, String description, BigDecimal price, String cur, Date date) {
        offer.setId(id);
        offer.setTitle(title);
        offer.setDescription(description);
        offer.setPrice(price);
        offer.setCurrency(cur);
        offer.setExpireDate(date);
    }
}