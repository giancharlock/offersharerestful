package com.worldpay.codescreen.offershare.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldpay.codescreen.offershare.dao.impl.OfferDAOImplBaseTest;
import com.worldpay.codescreen.offershare.pojo.Offer;
import com.worldpay.codescreen.offershare.service.EverybodyService;
import com.worldpay.codescreen.offershare.service.MerchantService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = { OfferShareFacade.class,
        OfferShareExceptionHandler.class},
        secure = false)
public abstract class OfferShareFacadeBaseTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MerchantService merchantService;

    @MockBean
    EverybodyService everybodyService;

    @Autowired
    ObjectMapper objectMapper;

    String result = "[{\"id\":1,\"title\":\"title\",\"description\":\"descr\",\"currency\":\"EUR\",\"price\":34.56,\"expireDate\":\"2019-02-10 11:00\",\"expired\":true},{\"id\":2,\"title\":\"title 2\",\"description\":\"descr 2\",\"currency\":\"EUR\",\"price\":100.99,\"expireDate\":\"2099-02-10 22:59\",\"expired\":false}]";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    static final String BASE_EP = "/offershare";

    Offer getOffer(){
        try {
            return OfferDAOImplBaseTest.getOffer(
                    1l,
                    "title",
                    "descr",
                    "EUR",
                    "34.56",
                    sdf.parse("2019-02-10 19:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    Offer getInvalidOffer(){
        return OfferDAOImplBaseTest.getOffer(
                    1l,
                    "title",
                    "descr",
                    "EUR",
                    "34.56",
                    null);
    }

    List<Offer> getOffers(){
        List<Offer> offers = new ArrayList<>();
        try {
            offers.add(
                    OfferDAOImplBaseTest.getOffer(
                    1l,
                    "title",
                    "descr",
                    "EUR",
                    "34.56",
                            sdf.parse("2019-02-10 12:00")
                    )
            );
            offers.add(
                    OfferDAOImplBaseTest.getOffer(
                            2l,
                            "title 2",
                            "descr 2",
                            "EUR",
                            "100.99",
                            sdf.parse("2099-02-10 23:59")
                    )
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return offers;
    }
}
