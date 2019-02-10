package com.worldpay.codescreen.offershare.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Offer implements Serializable {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "TITLE",nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "CUR", nullable = false)
    private String currency;

    @Column(name="PRICE", nullable = false)
    @JsonFormat(pattern = "")
    private BigDecimal price;

    @Column(name = "EXPIRE_DATE", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date expireDate;

    @Transient
    private boolean expired;

    public boolean isExpired() {
        return new Date().after(getExpireDate());
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id.equals(offer.id) &&
                title.equals(offer.title) &&
                description.equals(offer.description) &&
                currency.equals(offer.currency) &&
                price.equals(offer.price) &&
                Objects.equals(expireDate, offer.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, currency, price, expireDate);
    }
}
