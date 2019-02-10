package com.worldpay.codescreen.offershare.rest;

import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import com.worldpay.codescreen.offershare.pojo.Offer;
import org.junit.Test;

import static org.mockito.BDDMockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OfferShareFacadeMerchantTest extends OfferShareFacadeBaseTest{

    @Test
    public void insertOffer() throws Exception {
        doNothing().when(merchantService).insertOffer(any(Offer.class));

        mockMvc.perform(post(BASE_EP+OfferShareFacade.MERCHANT_EP_ADD)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(getOffer())))
                .andExpect(status().isCreated());
    }

    @Test
    public void insertOffer1() throws Exception {
        doNothing().when(merchantService).insertOffer(any(Offer.class));

        mockMvc.perform(post(BASE_EP+OfferShareFacade.MERCHANT_EP_ADD)
                .contentType(APPLICATION_JSON)
                .content(getJson(0)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void insertOffer2() throws Exception {
        doNothing().when(merchantService).insertOffer(any(Offer.class));

        mockMvc.perform(post(BASE_EP+OfferShareFacade.MERCHANT_EP_ADD)
                .contentType(APPLICATION_JSON)
                .content(getJson(1)))
                .andExpect(status().isCreated());
    }

    @Test
    public void insertOffer3() throws Exception {
        doNothing().when(merchantService).insertOffer(any(Offer.class));

        mockMvc.perform(post(BASE_EP+OfferShareFacade.MERCHANT_EP_ADD)
                .contentType(APPLICATION_JSON)
                .content(getJson(3)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void insertOffer4() throws Exception {
        doNothing().when(merchantService).insertOffer(any(Offer.class));

        mockMvc.perform(post(BASE_EP+OfferShareFacade.MERCHANT_EP_ADD)
                .contentType(APPLICATION_JSON)
                .content(getJson(4)))
                .andExpect(status().isBadRequest());
    }

    private String getJson(int i) {
        switch(i){
            case 0:
                return "{\"id\":1,\"title\":\"title\",\"description\":\"descr\"," +
                        "\"currency\":\"EUR\",\"price\":34.56,\"expireDate\":\"2019-02-10T11:00:00.000+0000\"}";
            case 1: // id and prise as strings
                return "{\"id\":\"1\",\"title\":\"title\",\"description\":\"descr\"," +
                        "\"currency\":\"EUR\",\"price\":\"34.56\",\"expireDate\":\"2019-02-10 11:00\"}";
            case 2: //Bad id
                return "{\"id\":\"alll\",\"title\":\"title\",\"description\":\"descr\"," +
                        "\"currency\":\"EUR\",\"price\":\"34.56\",\"expireDate\":\"2019-02-10 11:00\"}";
            case 3: //Bad price
                return "{\"id\":1,\"title\":\"title\",\"description\":\"descr\"," +
                        "\"currency\":\"EUR\",\"price\":\"bad_price\",\"expireDate\":\"2019-02-10 11:00\"}";
            case 4: // Missing field
                return "{\"id\":1,\"description\":\"descr\"," +
                        "\"currency\":\"EUR\",\"price\":\"bad_price\",\"expireDate\":\"2019-02-10 11:00\"}";
            default:
                return "";
        }
    }

    @Test
    public void insertOffer_ko() throws Exception {
        doThrow(new GenericOfferException("")).when(merchantService).insertOffer(any(Offer.class));

        mockMvc.perform(post(BASE_EP+OfferShareFacade.MERCHANT_EP_ADD)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(getOffer())))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void deleteOffer() throws Exception {
        doNothing().when(merchantService).deleteOffer(any(Long.class));

        mockMvc.perform(post(BASE_EP+OfferShareFacade.MERCHANT_EP_DEL+"/"+getOffer().getId())
                .contentType(APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void deleteOffer_ko() throws Exception {
        doThrow(new GenericOfferException("")).when(merchantService).deleteOffer(getOffer().getId());

        mockMvc.perform(post(BASE_EP+OfferShareFacade.MERCHANT_EP_DEL+"/"+getOffer().getId())
                .contentType(APPLICATION_JSON)).andExpect(status().isInternalServerError());
    }

}