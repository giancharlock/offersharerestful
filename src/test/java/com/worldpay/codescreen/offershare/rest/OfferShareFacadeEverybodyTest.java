package com.worldpay.codescreen.offershare.rest;

import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OfferShareFacadeEverybodyTest extends OfferShareFacadeBaseTest {

    @Test
    public void getAll() throws Exception {
        when(everybodyService.getAllOffers()).thenReturn(getOffers());

        mockMvc.perform(get(BASE_EP+OfferShareFacade.EP_GETALL))
                .andExpect(
                (MvcResult mvcResult) ->
                { Assert.assertEquals(result, mvcResult.getResponse().getContentAsString()); }
        );
    }

    @Test
    public void getAll_ko() throws Exception {
        doThrow(new GenericOfferException("")).when(everybodyService).getAllOffers();

        mockMvc.perform(get(BASE_EP+OfferShareFacade.EP_GETALL))
                .andExpect(status().isInternalServerError());

    }

    @Test
    public void getAllNotExpired() throws Exception {
        when(everybodyService.getAllNotExpiredOffers()).thenReturn(getOffers());

        mockMvc.perform(get(BASE_EP + OfferShareFacade.EP_GETALL_NOT_EXPIRED))
                .andExpect(
                        (MvcResult mvcResult) ->
                        { Assert.assertEquals(result, mvcResult.getResponse().getContentAsString()); }
                        );
    }
    @Test
    public void getAllNotExpired_ko() throws Exception {
        doThrow(new GenericOfferException("")).when(everybodyService).getAllNotExpiredOffers();

        mockMvc.perform(get(BASE_EP+OfferShareFacade.EP_GETALL_NOT_EXPIRED))
                .andExpect(status().isInternalServerError());

    }
}
