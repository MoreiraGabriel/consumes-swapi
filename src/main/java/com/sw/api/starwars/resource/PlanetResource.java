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
import com.sw.api.starwars.exception.PlanetNotFoundException;
import com.sw.api.starwars.service.PlanetService;
import com.sw.api.starwars.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("planet")
@Api(value = "Controller para Person")
public class PlanetResource {

	@Autowired
	PlanetService service;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso",  response = PlanetApiDto.class ),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = Exception.class),
	})
	@ApiOperation(value = "Endpoint para listar planeta por id da swapi.")
	@GetMapping("api/{id}")
	public PlanetApiDto getByIdApi(@PathVariable(value = "id") String id){
		return service.getByIdApi(id);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso",  response = PlanetApiDto.class ),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = Exception.class),
	})
	@ApiOperation(value = "Endpoint para listar todos os planetas da swapi.")
	@GetMapping("api")
	public List<PlanetApiDto> getAllApi(){
		return service.getAllApi();
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso",  response = PlanetDto.class ),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = Exception.class),
	})
	@ApiOperation(value = "Endpoint para atualizar base de acordo com a swapi.")
	@PostMapping("api")
	public List<PlanetDto> updateDataBase(){
		return service.updateDatabaseForApi();
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso",  response = PlanetDto.class ),
			@ApiResponse(code = 404, message = "Não encontrado", response = PlanetNotFoundException.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = Exception.class),
	})
	@ApiOperation(value = "Endpoint para listar planeta por id.")
	@GetMapping("{id}")
	public PlanetDto getById(@PathVariable(value = "id") String id){
		return service.getById(id);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso",  response = List.class ),
			@ApiResponse(code = 404, message = "Não encontrado", response = PlanetNotFoundException.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = Exception.class),
	})
	@ApiOperation(value = "Endpoint para listar todos os planetas.")
	@GetMapping
	public List<PlanetDto> getAll(){
		return service.getAll();
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso",  response = PlanetDto.class ),
			@ApiResponse(code = 404, message = "Não encontrado", response = PlanetNotFoundException.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = Exception.class),
	})
	@ApiOperation(value = "Endpoint criar novo planeta.")
	@PostMapping
	public ResponseEntity<Response<PlanetDto>> create(@RequestBody @Valid PlanetRequest request){
		Response<PlanetDto> response = new Response<>();
		PlanetDto dto = service.create(request);
		response.setData(dto);
		return ResponseEntity.ok(response);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso",  response = PlanetDto.class ),
			@ApiResponse(code = 404, message = "Não encontrado", response = PlanetNotFoundException.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = Exception.class),
	})
	@ApiOperation(value = "Endpoint atualizar planeta.")
	@PutMapping("{id}")
	public ResponseEntity<Response<PlanetDto>> update(@PathVariable String id, @RequestBody PlanetRequest request){
		Response<PlanetDto> response = new Response<>();
		PlanetDto dto = service.update(id, request);
		response.setData(dto);
		return ResponseEntity.ok(response);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 404, message = "Não encontrado", response = PlanetNotFoundException.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = Exception.class),
	})
	@ApiOperation(value = "Endpoint deletar planeta por id.")
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
