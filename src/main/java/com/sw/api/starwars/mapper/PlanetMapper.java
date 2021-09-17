package com.sw.api.starwars.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.sw.api.starwars.dto.PlanetApiDto;
import com.sw.api.starwars.dto.PlanetDto;
import com.sw.api.starwars.dto.request.PlanetRequest;
import com.sw.api.starwars.entity.Planet;

public class PlanetMapper {

	public static Planet mapperApiToPlanet(PlanetApiDto dto) {
		Planet planet = new Planet();
		planet.setName(dto.getName());
		planet.setClimate(dto.getClimate());
		planet.setTerrain(dto.getTerrain());
		planet.setNumFilms(dto.getNumFilms());
		return planet;
	}
	
	public static Planet mapperRequestToPlanet(PlanetRequest request) {
		Planet planet = new Planet();
		planet.setName(request.getName());
		planet.setClimate(request.getClimate());
		planet.setTerrain(request.getTerrain());
		planet.setNumFilms(request.getNumFilms());
		return planet;
	}
	
	public static List<Planet> mapperToList(List<PlanetDto> dtos) {
		
		List<Planet> planets = dtos.stream().map(d -> {
			Planet p = new Planet();
			p.setId(d.getId() != null ? d.getId() : null); 
			p.setName(d.getName());
			p.setClimate(d.getClimate());
			p.setTerrain(d.getTerrain());
			p.setNumFilms(d.getNumFilms());
			return p;
		}).collect(Collectors.toList());
		
		return planets;
	}
	
	public static List<PlanetDto> mapperToListDto(List<Planet> planets) {
		
		List<PlanetDto> dtos = planets.stream().map(d -> {
			PlanetDto dto = new PlanetDto(d);	
			return dto;
		}).collect(Collectors.toList());
		
		return dtos;
	}
	
public static List<Planet> mapperApiToEntity(List<PlanetApiDto> dtos) {
		
		List<Planet> planets = dtos.stream().map(d -> {
			Planet p = new Planet();
			p.setName(d.getName());
			p.setClimate(d.getClimate());
			p.setTerrain(d.getTerrain());
			p.setNumFilms(d.getNumFilms());
			return p;
		}).collect(Collectors.toList());
		
		return planets;
	}

}
