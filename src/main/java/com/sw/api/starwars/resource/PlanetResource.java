package com.sw.api.starwars.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw.api.starwars.dto.PlanetApiDto;
import com.sw.api.starwars.dto.PlanetDto;
import com.sw.api.starwars.dto.request.PlanetRequest;
import com.sw.api.starwars.service.PlanetService;
import com.sw.api.starwars.util.Response;

@RestController
@RequestMapping("planet")
public class PlanetResource {

	@Autowired
	PlanetService service;
	
	@GetMapping("api/{id}")
	public PlanetApiDto getByIdApi(@PathVariable(value = "id") String id){
		return service.getByIdApi(id);
	}
	
	@GetMapping("api")
	public List<PlanetApiDto> getAllApi(){
		return service.getAllApi();
	}
	
	@PostMapping("api")
	public List<PlanetDto> updateDataBase(){
		return service.updateDatabaseForApi();
	}
	
	@GetMapping("{id}")
	public PlanetDto getById(@PathVariable(value = "id") String id){
		return service.getById(id);
	}
	
	@GetMapping
	public List<PlanetDto> getAll(){
		return service.getAll();
	}
	
	@PostMapping
	public ResponseEntity<Response<PlanetDto>> create(@RequestBody @Valid PlanetRequest request){
		Response<PlanetDto> response = new Response<>();
		PlanetDto dto = service.create(request);
		response.setData(dto);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Response<PlanetDto>> update(@PathVariable String id, @RequestBody PlanetRequest request){
		Response<PlanetDto> response = new Response<>();
		PlanetDto dto = service.update(id, request);
		response.setData(dto);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
