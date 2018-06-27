package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.SkiplossService;

@Controller
public class Client {
	
	@Autowired
	private SkiplossService skiplossService;
	
	
	@RequestMapping(value = "/client/vehicles/{vin}/skiploss", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Skiploss getSkiploss(@PathVariable("vin") String vin) {
		return skiplossService.getSkiploss(vin);
	}

}
