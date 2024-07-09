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
import com.desafioApi.ApiCarros.entities.ClienteEntity;
import com.desafioApi.ApiCarros.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	//Nota: Atualizar as mensagens de sucesso. Use o Postman para ver o que de fato é retornado!
	
	//find client by id
	
	@Operation(summary = "Encontrar cliente pelo ID", description = "Funcionalidade responsavel pela busca de clientes pelo ID")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Cliente Encontrado com sucesso!",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = ClienteEntity.class)
					)
			),
			@ApiResponse(responseCode = "400", description = "Não foi possivel encontrar!")
	})
	@GetMapping("/{id}")
	public Optional<ClienteEntity> findClientbyId(@PathVariable Long id) {
		return service.findClientbyId(id);
	}
	
	
	//find all clients
	@Operation(summary= "Busca de todos os clientes", description="Funcionalidade responsavel pela busca de todos os clientes e seus respectivos veiculos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="Clientes encontrados com sucesso",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = ClienteEntity.class)
				)
			)
	})
	@GetMapping
	public List<ClienteEntity> findAllClients(){
		return service.findAllUser();
	}
	
	
	//Create a Cliente
	
	
	@Operation(summary="Criar um cliente", description="Funcionalidade responsavel por criar um cliente. Não é necessario criar um carro junto")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Cliente criado com sucesso!",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = ClienteEntity.class)
				)
			),
			@ApiResponse(responseCode="400", description="Não foi possivel criar!")
	})
	@PostMapping("/create")
	public ClienteEntity createUser(@RequestBody ClienteEntity cliente) {
		return service.createUser(cliente);
	}
	
	//Update Cliente
	
	 @Operation(summary= "Atualizar um cliente por id", description="Funcionalidade responsavel por criar um cliente por id")
	 @ApiResponses(value= {
			 @ApiResponse(responseCode="200", description="Cliente atualizado com sucesso",
					 content = @Content(mediaType = "application/json",
					 schema = @Schema(implementation = ClienteEntity.class)
				)
			),
			 @ApiResponse(responseCode="400",description="Não foi possivel atualizar o cliente")
	 })
	 @PutMapping("/update/{id}")
	    public ClienteEntity updateUser(@RequestBody ClienteEntity cliente, @PathVariable("id") Long clienteId) {
	        return service.updateUser(cliente, clienteId);
	    }
	
	//delete Cliente
	
	@Operation(summary = "Deletar Cliente por id", description="Funcionalidade responsavel por deletar um Cliente pelo seu ID")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "cliente deletado com sucesso",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = ClienteEntity.class)
			)
		),
			@ApiResponse(responseCode = "400", description = "Não foi possivel encontrar o cliente")
	})
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
	
}
