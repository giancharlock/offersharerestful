package com.worldpay.codescreen.offershare.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.worldpay.codescreen.offershare.pojo.Offer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class OfferDTO implements Serializable {

    @NotNull
    private Long id;

    @NotNull
    @Size(min=1, max = 80)
    private String title;

    @NotNull
    @Size(min=1, max = 4000)
    private String description;

    @Size(min=3, max = 3)
    private String currency="EUR";

    @NotNull
    private BigDecimal price;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date expireDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Offer getOfferEntity() {
        Offer offer = new Offer();
        offer.setCurrency(this.getCurrency());
        offer.setDescription(this.getDescription());
        offer.setExpireDate(this.getExpireDate());
        offer.setId(this.getId());
        offer.setPrice(this.getPrice());
        offer.setTitle(this.getTitle());
        return offer;
    }
}

