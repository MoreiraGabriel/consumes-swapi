package com.sw.api.starwars.dto;

import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "DTO para retorno da api swapi.")
public class PlanetApiDto {
	
	private String name;
	
	private String climate;
	
	private String terrain;
	
	private Integer numFilms;

	public PlanetApiDto(Results result) {
		this.name = result.getName();
		this.climate = result.getClimate();
		this.terrain = result.getTerrain();
		this.numFilms = result.getFilms().size();
	}
	
	public static List<PlanetApiDto> convertToPlanetDto(List<Results> results) {
		return results.stream().map(PlanetApiDto::new).collect(Collectors.toList());
	}

}
