package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.client.Skiploss;

@FeignClient(name = "spring-boot-service", fallback=FeighCliengFallback.class)
public interface SkiplossService {
	
	@GetMapping(value = "/service/vehicles/{vin}/skiploss")
	public Skiploss getSkiploss(@PathVariable("vin") String vin);

}


@Component
class FeighCliengFallback implements SkiplossService {

	@Override
	public Skiploss getSkiploss(String vin) {
		return new Skiploss();
	}
	
}


