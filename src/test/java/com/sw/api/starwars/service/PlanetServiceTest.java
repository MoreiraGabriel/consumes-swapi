package com.sw.api.starwars.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.sw.api.starwars.dto.PlanetDto;
import com.sw.api.starwars.dto.request.PlanetRequest;
import com.sw.api.starwars.entity.Planet;
import com.sw.api.starwars.repository.PlanetRepository;
import com.sw.api.starwars.service.impl.PlanetServiceImpl;

@SpringBootTest
public class PlanetServiceTest {

	@Mock
	private PlanetRepository repository;
	
	@InjectMocks
	private PlanetServiceImpl service;
	
	private Planet planet;
	private PlanetDto dto;
	private List<Planet> planets = new ArrayList<>();
	private List<PlanetDto> dtos = new ArrayList<>();
	private PlanetRequest request;
	
	@BeforeEach
	public void Setup() {
		planet = new Planet("123456", "name", "climate", "terrain", 5);
		request = new PlanetRequest("name", "climate", "terrain", 3);
		planets.add(planet);
		dto = new PlanetDto(planet);
		dtos.add(dto);
	}
	
	@Test
	void getByIdTest() {
		when(repository.findById("123456")).thenReturn(Optional.of(planet));
		
		PlanetDto planet = service.getById("123456");
		
		assertEquals(dto, planet);
	}
	
	@Test
	void getAll() {
		when(repository.findAll()).thenReturn(planets);		
		List<PlanetDto> planets = service.getAll();		
		assertEquals(dtos, planets);
	}
	
	@Test
	void createTest() {
		when(repository.save(Mockito.any())).thenReturn(planet);
		PlanetDto planet = service.create(request);		
		assertEquals(request.getName(), planet.getName());
	}
	
	@Test
	void updateTest() {
		when(repository.existsById(Mockito.any())).thenReturn(true);
		when(repository.save(Mockito.any())).thenReturn(planet);
		PlanetDto planet = service.update("123456", request);		
		assertEquals(request.getName(), planet.getName());
	}
	
}
