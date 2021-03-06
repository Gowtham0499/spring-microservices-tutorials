package com.currency.exchange.service.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.exchange.service.app.model.CurrencyExchange;
import com.currency.exchange.service.app.repositories.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeForexController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@GetMapping("/forex-api/from/{from}/to/{to}")
	public CurrencyExchange retrieveForexRates(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to find data for " + from + " to " + to);
		}
		
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}

}
