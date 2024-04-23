package com.desafioApi.ApiCarros.services;

import org.springframework.stereotype.Service;

import com.desafioApi.ApiCarros.repositores.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	
	
}
