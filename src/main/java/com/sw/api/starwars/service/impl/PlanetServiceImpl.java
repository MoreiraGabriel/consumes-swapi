package com.sw.api.starwars.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.api.starwars.dto.PlanetDto;
import com.sw.api.starwars.dto.Result;
import com.sw.api.starwars.dto.Results;
import com.sw.api.starwars.dto.request.PlanetRequest;
import com.sw.api.starwars.entity.Planet;
import com.sw.api.starwars.mapper.PlanetMapper;
import com.sw.api.starwars.repository.PlanetRepository;
import com.sw.api.starwars.service.PlanetService;
import com.sw.api.starwars.service.feign.SwapiClient;

@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	PlanetRepository repository;
	
	@Autowired
	SwapiClient swapiClient;

	@Override
	public List<PlanetDto> getAllApi() {
		Result result = swapiClient.getPlanets();
		List<PlanetDto> list = PlanetDto.convertToPlanetDto(result.results);
		return list;
	}
	
	@Override
	public PlanetDto getById(String id) {
		Results result = swapiClient.getPlanetsById(id);
		PlanetDto dto = new PlanetDto(result);
		return dto;
	}

	@Override
	public List<PlanetDto> updateDatabaseForApi() {
		
		List<PlanetDto> list = getAllApi();
		
		if(!list.isEmpty()) {
			repository.deleteAll();
			List<Planet> planets = PlanetMapper.mapperToList(list);
			
			List<Planet> res = repository.saveAll(planets);
			
			return PlanetMapper.mapperToListDto(res);
		}
		
		return null;
	}

	@Override
	public List<PlanetDto> getAll() {
		List<Planet> planets = repository.findAll();		
		return PlanetMapper.mapperToListDto(planets);
	}

	@Override
	public PlanetDto create(PlanetRequest request) {
		Planet planet = PlanetMapper.mapperRequestToPlanet(request);
		planet = repository.save(planet);
		return new PlanetDto(planet);
	}

	@Override
	public PlanetDto update(String id, PlanetRequest request) {
		Planet planet = PlanetMapper.mapperRequestToPlanet(request);
		planet.setId(id);
		planet = repository.save(planet);
		return new PlanetDto(planet);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}
}
