package com.currency.exchange.repository;

import com.currency.exchange.domain.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long>{
    ExchangeValue findByFromAndTo(String from,String to);
    @Query("SELECT e FROM ExchangeValue e WHERE e.from=:from AND e.to=:to")
    ExchangeValue findRecords(@Param("from")String from, @Param("to")String to);
    //Hello world
}
