package com.sw.api.starwars.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.sw.api.starwars.entity.Planet;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanetDto {
	
	private String id;
	
	private String name;
	
	private String climate;
	
	private String terrain;
	
	private Integer numFilms;

	public PlanetDto(Results result) {
		this.name = result.getName();
		this.climate = result.getClimate();
		this.terrain = result.getTerrain();
		this.numFilms = result.getFilms().size();
	}
	
	public PlanetDto(Planet planet) {
		this.id = planet.getId();
		this.name = planet.getName();
		this.climate = planet.getClimate();
		this.terrain = planet.getTerrain();
		this.numFilms = planet.getNumFilms();
	}

	public static List<PlanetDto> convertToPlanetDto(List<Results> results) {
		return results.stream().map(PlanetDto::new).collect(Collectors.toList());
	}

}
