package com.worldpay.codescreen.offershare.dao;

import com.worldpay.codescreen.offershare.pojo.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OfferDAO extends JpaRepository<Offer,Long> {
    @Query("select o from Offer o where o.expireDate > :currentDate")
    List<Offer> findAllNotExpired(@Param("currentDate") Date currentDate);
}
