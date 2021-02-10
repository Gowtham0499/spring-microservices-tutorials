package com.currency.conversion.service.app.controllers;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency.conversion.service.app.model.CurrencyConversion;
import com.currency.conversion.service.app.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping(value = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity("http://localhost:8000/forex-api/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getForexExchangeRateValue(), quantity.multiply(currencyConversion.getForexExchangeRateValue()), currencyConversion.getEnvironment() + " " + "Rest Template");
		
	}
	
	@GetMapping(value = "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConversion currencyConversion = proxy.getForexExchangeRate(from, to);
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getForexExchangeRateValue(), quantity.multiply(currencyConversion.getForexExchangeRateValue()), currencyConversion.getEnvironment()+ " " + "Feign");
	}

}
