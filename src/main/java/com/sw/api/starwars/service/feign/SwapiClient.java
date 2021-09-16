package com.sw.api.starwars.service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "starwars-api", url = "${feign.apis.swapi.url}")
public interface SwapiClient {
	
	@GetMapping(value = "/planets", produces = "application/json")
	Object getPlanets();

	@GetMapping(value = "planets/{id}", produces = "application/json")
	Object getPlanetsById(@PathVariable String id);
}
