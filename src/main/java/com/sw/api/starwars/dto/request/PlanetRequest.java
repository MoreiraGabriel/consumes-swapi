package com.sw.api.starwars.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanetRequest {

	@NotBlank(message = "Name required")
	private String name;
	
	@NotBlank(message = "climate required")
	private String climate;
	
	@NotBlank(message = "terrain required")
	private String terrain;
	
	private Integer numFilms;
}
