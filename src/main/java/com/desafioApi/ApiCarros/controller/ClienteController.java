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

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	
	//find client by id
	
	@GetMapping("/{id}")
	public Optional<ClienteEntity> findClientbyId(@PathVariable Long id) {
		return service.findClientbyId(id);
	}
	
	
	//find all clients
	@GetMapping
	public List<ClienteEntity> findAllClients(){
		return service.findAllUser();
	}
	
	
	//Create a Cliente
	
	@PostMapping("/create")
	public ClienteEntity createUser(@RequestBody ClienteEntity cliente) {
		return service.createUser(cliente);
	}
	
	//Update Cliente
	
	 @PutMapping("/update/{id}")
	    public ClienteEntity updateUser(@RequestBody ClienteEntity cliente, @PathVariable("id") Long clienteId) {
	        return service.updateUser(cliente, clienteId);
	    }
	
	//delete Cliente
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
	
}
