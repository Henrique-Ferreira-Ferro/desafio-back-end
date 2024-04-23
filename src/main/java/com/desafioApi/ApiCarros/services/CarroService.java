package com.desafioApi.ApiCarros.services;

import org.springframework.stereotype.Service;

import com.desafioApi.ApiCarros.repositores.CarroRepository;

@Service
public class CarroService {
	
	private CarroRepository repository;
	
	public CarroService(CarroRepository repository) {
		this.repository = repository;
	}
	
	
}
