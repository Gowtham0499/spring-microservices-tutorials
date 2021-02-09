package com.currency.exchange.service.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.exchange.service.app.model.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
