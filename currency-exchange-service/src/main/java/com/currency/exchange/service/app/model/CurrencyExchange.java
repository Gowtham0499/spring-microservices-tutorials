package com.currency.exchange.service.app.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {

	@Id
	private Long id;
	
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	
	private BigDecimal forexExchangeRateValue;
	private String environment;
	
	public CurrencyExchange() {
		
	}

	public CurrencyExchange(Long id, String from, String to, BigDecimal forexExchangeRateValue) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.forexExchangeRateValue = forexExchangeRateValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getForexExchangeRateValue() {
		return forexExchangeRateValue;
	}

	public void setForexExchangeRateValue(BigDecimal forexExchangeRateValue) {
		this.forexExchangeRateValue = forexExchangeRateValue;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
