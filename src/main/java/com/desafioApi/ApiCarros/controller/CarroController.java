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

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	CarroService service;
	
	@GetMapping("/{id}")
	public Optional<CarroEntity> findCarById(@PathVariable Long id){
		return service.findCarById(id);
	}
	
	@GetMapping
	public List<CarroEntity> findAllCars(){
		return service.findAllCars();
	}
	
	//Insere um carro, além de associar a um cliente
	@PostMapping("/create/{id}")
	public CarroEntity createCar(@RequestBody CarroEntity carro, @PathVariable Long id) {
		return service.createCar(carro,id);
	}
	
	@PutMapping("/update/{id}")
	public CarroEntity updateCar(@RequestBody CarroEntity carro, @PathVariable Long id) {
		return service.updateCar(carro, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCar(@PathVariable Long id) {
		return service.deleteCar(id);
	}
	
	
}
