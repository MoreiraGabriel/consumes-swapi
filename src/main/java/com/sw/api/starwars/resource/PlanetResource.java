package com.sw.api.starwars.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw.api.starwars.dto.PlanetDto;
import com.sw.api.starwars.service.PlanetService;

@RestController
@RequestMapping("planet")
public class PlanetResource {

	@Autowired
	PlanetService service;
	
	@GetMapping("{id}")
	public PlanetDto getAll(@PathVariable(value = "id") String id){
		return service.getById(id);
	}
	
	@GetMapping("api")
	public List<PlanetDto> getAllApi(){
		return service.getAllApi();
	}
	
	@PostMapping
	public List<PlanetDto> updateDataBase(){
		return service.updateDatabaseForApi();
	}
}
