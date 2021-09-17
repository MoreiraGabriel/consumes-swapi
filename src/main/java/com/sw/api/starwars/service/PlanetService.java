package com.sw.api.starwars.service;

import java.util.List;

import com.sw.api.starwars.dto.PlanetApiDto;
import com.sw.api.starwars.dto.PlanetDto;
import com.sw.api.starwars.dto.request.PlanetRequest;

public interface PlanetService {
	
	List<PlanetDto> updateDatabaseForApi();

	List<PlanetApiDto> getAllApi();
	
	PlanetApiDto getByIdApi(String id);
	
	List<PlanetDto> getAll();
	
	PlanetDto getById(String id);
	
	PlanetDto create(PlanetRequest request);
	
	PlanetDto update(String id, PlanetRequest request);
	
	void delete(String id);

}
