package com.sw.api.starwars.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanetRequest {

	@NotBlank
	private String name;
	
	@NotBlank
	private String climate;
	
	@NotBlank
	private String terrain;
	
	private Integer numFilms;
}
