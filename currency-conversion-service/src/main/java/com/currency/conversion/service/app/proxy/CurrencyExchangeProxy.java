package com.currency.conversion.service.app.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.conversion.service.app.model.CurrencyConversion;

//@FeignClient(name = "forex-api", url = "localhost:8000")
@FeignClient(name = "forex-api")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/forex-rates/from/{from}/to/{to}")
	public CurrencyConversion getForexExchangeRate(@PathVariable String from, @PathVariable String to);

}
