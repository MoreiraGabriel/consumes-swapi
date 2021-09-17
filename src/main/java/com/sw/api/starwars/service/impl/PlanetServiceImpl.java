package com.sw.api.starwars.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.api.starwars.dto.PlanetApiDto;
import com.sw.api.starwars.dto.PlanetDto;
import com.sw.api.starwars.dto.Result;
import com.sw.api.starwars.dto.Results;
import com.sw.api.starwars.dto.request.PlanetRequest;
import com.sw.api.starwars.entity.Planet;
import com.sw.api.starwars.exception.PlanetNotFoundException;
import com.sw.api.starwars.mapper.PlanetMapper;
import com.sw.api.starwars.repository.PlanetRepository;
import com.sw.api.starwars.service.PlanetService;
import com.sw.api.starwars.service.feign.SwapiClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	PlanetRepository repository;
	
	@Autowired
	SwapiClient swapiClient;

	@Override
	public List<PlanetApiDto> getAllApi() {
		log.info("getAllApi - Start");
		
		Result result = swapiClient.getPlanets();
		List<PlanetApiDto> list = PlanetApiDto.convertToPlanetDto(result.results);
		
		log.info("getAllApi - End");
		
		return list;
	}
	
	@Override
	public PlanetApiDto getByIdApi(String id) {
		log.info("getByIdApi - Start: " + id);
		
		Results result = swapiClient.getPlanetsById(id);
		PlanetApiDto dto = new PlanetApiDto(result);
		
		log.info("getByIdApi - End: " + id);
		
		return dto;
	}

	@Override
	public List<PlanetDto> updateDatabaseForApi() {
		log.info("updateDatabaseForApi - Start");
		
		List<PlanetApiDto> list = new ArrayList<>();
		
		try {
			log.info("Search planets swapi");
			
			list = getAllApi();
		} catch (Exception e) {
			e.getMessage();
		}
		
		repository.deleteAll();
		List<Planet> planets = PlanetMapper.mapperApiToEntity(list);
		
		List<Planet> res = repository.saveAll(planets);
		
		log.info("updateDatabaseForApi - End");
		
		return PlanetMapper.mapperToListDto(res);
	}

	@Override
	public List<PlanetDto> getAll() {
		log.info("getAll - Start");
		
		List<Planet> planets = repository.findAll();
		
		log.info("getAll - End");
		
		return PlanetMapper.mapperToListDto(planets);
	}
	
	@Override
	public PlanetDto getById(String id) {
		log.info("getById - Start: " + id);
		
		Optional<Planet> planet = repository.findById(id);
		
		if(planet.isEmpty()){
			throw new PlanetNotFoundException("Planet not Found: " + id);
		}
		PlanetDto dto = new PlanetDto(planet.get());
		
		log.info("getById - End: " + id);
		
		return dto;
	}

	@Override
	public PlanetDto create(PlanetRequest request) {
		log.info("create - Start");
		
		Planet planet = PlanetMapper.mapperRequestToPlanet(request);
		planet = repository.save(planet);
		
		log.info("create - End");
		return new PlanetDto(planet);
	}

	@Override
	public PlanetDto update(String id, PlanetRequest request) {
		log.info("update - Start: " + id);
		
		if(!repository.existsById(id)){
			throw new PlanetNotFoundException("Planet not Found: " + id);
		}
		
		Planet planet = PlanetMapper.mapperRequestToPlanet(request);
		planet.setId(id);
		planet = repository.save(planet);
		
		log.info("update - End: " + id);
		
		return new PlanetDto(planet);
	}

	@Override
	public void delete(String id) {
		log.info("delete - Start: " + id);
		
		if(!repository.existsById(id)){
			throw new PlanetNotFoundException("Planet not Found: " + id);
		}
		
		repository.deleteById(id);
		
		log.info("delete - End: " + id);
	}

}
