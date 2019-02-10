package com.worldpay.codescreen.offershare.rest;

import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import com.worldpay.codescreen.offershare.pojo.Offer;
import com.worldpay.codescreen.offershare.service.EverybodyService;
import com.worldpay.codescreen.offershare.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/offershare")
public class OfferShareFacade {
    @Autowired
    private EverybodyService everybodyService;

    @Autowired
    private MerchantService merchantService;

    protected static final String MERCHANT_EP_ADD = "/add";
    protected static final String MERCHANT_EP_DEL = "/del";
    protected static final String EP_GETALL = "/all";
    protected static final String EP_GETALL_NOT_EXPIRED = "/notexpired";

    @RequestMapping(value = MERCHANT_EP_ADD, method = RequestMethod.POST)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    public void insertOffer(@Valid @RequestBody Offer offer, HttpServletResponse response) throws GenericOfferException {
        merchantService.insertOffer(offer);
        response.setStatus(HttpStatus.CREATED.value());
    }

    @RequestMapping(value = MERCHANT_EP_DEL+"/{id}", method = RequestMethod.POST)
    public void deleteOffer(@Valid @PathVariable Long id, HttpServletResponse response) throws GenericOfferException {
        merchantService.deleteOffer(id);
        response.setStatus(HttpStatus.OK.value());
    }

    @RequestMapping(value = EP_GETALL, method = RequestMethod.GET)
    public List<Offer> getAll(HttpServletResponse response) throws GenericOfferException {
        return everybodyService.getAllOffers();
    }

    @RequestMapping(value = EP_GETALL_NOT_EXPIRED, method = RequestMethod.GET)
    public List<Offer> getAllNotExpired(HttpServletResponse response) throws GenericOfferException {
        return everybodyService.getAllNotExpiredOffers();
    }

}
