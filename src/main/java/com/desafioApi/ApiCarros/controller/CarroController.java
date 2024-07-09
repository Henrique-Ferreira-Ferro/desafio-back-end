package com.desafioApi.ApiCarros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioApi.ApiCarros.entities.CarroEntity;
import com.desafioApi.ApiCarros.services.CarroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	CarroService service;
	
	
	@Operation(summary = "Pesquisar carro por ID", description="Funcionalidade que pesquisa carro por ID")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Carro encontrado com sucesso!",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = CarroEntity.class
					)
				)
			),
			@ApiResponse(responseCode = "400", description="Carro não encontrado!")			
	})
	@GetMapping("/{id}")
	public Optional<CarroEntity> findCarById(@PathVariable Long id){
		return service.findCarById(id);
	}
	
	@Operation(summary = "Pesquisa de todos os carros", description = "Funcionalidade responsavel pela busca de varios carros")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Carros encontrados!",
				content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = CarroEntity.class))
			)
	})
	@GetMapping
	public List<CarroEntity> findAllCars(){
		return service.findAllCars();
	}
	
	//Insere um carro, além de associar a um cliente
	@Operation(summary = "Criar um carro", description = "Funcionalidade responsavel por criar um carro e associar a um usuario")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carro criado com sucesso",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = CarroEntity.class)
				)
			),
			@ApiResponse(responseCode = "400", description="Não foi possivel criar o Carro")
	})
	@PostMapping("/create/{id}")
	public CarroEntity createCar(@RequestBody CarroEntity carro, @PathVariable Long id) {
		return service.createCar(carro,id);
	}
	
	@Operation(summary = "Atualizar um veiculo por id", description="Funcionalidade responsavel por atualizar um veiculo pelo seu id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Carro atualizado com sucesso!",
					content = @Content(mediaType="application/json",
					schema = @Schema(implementation=CarroEntity.class)
			)
		),
			@ApiResponse(responseCode = "400", description = "Não foi possivel atualizar o veiculo!")
	})
	@PutMapping("/update/{id}")
	public CarroEntity updateCar(@RequestBody CarroEntity carro, @PathVariable Long id) {
		return service.updateCar(carro, id);
	}
	
	
	@Operation(summary="Deletar veiculo", description = "Funcionalidade responsavel por deletar um veiculo pelo seu id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="Carro deletado com sucesso",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = CarroEntity.class)
			)
		),
			@ApiResponse(responseCode = "400", description="Não foi possivel deletar o veiculo")
	})
	@DeleteMapping("/{id}")
	public String deleteCar(@PathVariable Long id) {
		return service.deleteCar(id);
	}
	
}
