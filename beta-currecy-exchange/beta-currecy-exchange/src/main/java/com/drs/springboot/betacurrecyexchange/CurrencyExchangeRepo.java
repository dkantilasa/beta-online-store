package com.drs.springboot.betacurrecyexchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange,Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM CURRENCY_EXCHANGE WHERE CURRENCY_FROM = :from AND CURRENCY_TO = :to"
    )
    CurrencyExchange getCurrencyConversion(@Param("from") String from,@Param("to") String to);
}
