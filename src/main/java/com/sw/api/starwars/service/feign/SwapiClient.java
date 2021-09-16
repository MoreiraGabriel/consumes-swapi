package com.sw.api.starwars.service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sw.api.starwars.dto.Result;
import com.sw.api.starwars.dto.Results;

@FeignClient(name = "starwars-api", url = "https://swapi.dev/api")
public interface SwapiClient {
	
	@GetMapping(value = "/planets", produces = "application/json")
	Result getPlanets();

	@GetMapping(value = "planets/{id}", produces = "application/json")
	Results getPlanetsById(@PathVariable String id);
}
