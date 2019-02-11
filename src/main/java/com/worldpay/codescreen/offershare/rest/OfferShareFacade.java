package com.worldpay.codescreen.offershare.rest;

import com.worldpay.codescreen.offershare.exceptions.GenericOfferException;
import com.worldpay.codescreen.offershare.pojo.Offer;
import com.worldpay.codescreen.offershare.service.EverybodyService;
import com.worldpay.codescreen.offershare.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger log = LoggerFactory.getLogger(OfferShareFacade.class);

    @Autowired
    private EverybodyService everybodyService;

    @Autowired
    private MerchantService merchantService;

    protected static final String MERCHANT_EP_ADD = "/add";
    protected static final String MERCHANT_EP_DEL = "/del";
    protected static final String EP_GETALL = "/all";
    protected static final String EP_GETALL_NOT_EXPIRED = "/notexpired";

    @PostMapping(value = MERCHANT_EP_ADD)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    public void insertOffer(@Valid @RequestBody OfferDTO offer, HttpServletResponse response) throws GenericOfferException {
        log.debug("Offer in:"+offer.toString());
        merchantService.insertOffer(offer.getOfferEntity());
        response.setStatus(HttpStatus.CREATED.value());
        log.info("Offer added successfully:"+offer.toString());
    }

    @PostMapping(value = MERCHANT_EP_DEL+"/{id}")
    public void deleteOffer(@Valid @PathVariable Long id, HttpServletResponse response) throws GenericOfferException {
        log.debug("Deleting offer with id:"+id);
        merchantService.deleteOffer(id);
        response.setStatus(HttpStatus.OK.value());
        log.info("Offer deleted successfully for id:"+id);
    }

    @GetMapping(value = EP_GETALL)
    public List<Offer> getAll(HttpServletResponse response) throws GenericOfferException {
        log.debug("Get all method called");
        return everybodyService.getAllOffers();
    }

    @GetMapping(value = EP_GETALL_NOT_EXPIRED)
    public List<Offer> getAllNotExpired(HttpServletResponse response) throws GenericOfferException {
        log.debug("Get all not expired method called");
        return everybodyService.getAllNotExpiredOffers();
    }

}
