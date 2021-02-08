package com.limits.service.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limits.service.app.configurations.LimitsConfiguration;
import com.limits.service.app.model.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitsConfiguration limits;
	
	@GetMapping("/limits")
	public Limits getLimits() {
		return new Limits(limits.getMinimum(), limits.getMaximum());
	}

}
