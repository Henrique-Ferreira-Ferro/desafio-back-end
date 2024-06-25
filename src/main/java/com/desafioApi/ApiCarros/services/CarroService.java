package com.desafioApi.ApiCarros.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioApi.ApiCarros.entities.CarroEntity;
import com.desafioApi.ApiCarros.entities.ClienteEntity;
import com.desafioApi.ApiCarros.exceptions.BadRequestException;
import com.desafioApi.ApiCarros.repositores.CarroRepository;
import com.desafioApi.ApiCarros.repositores.ClienteRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repository;
	
	@Autowired
	private ClienteRepository repositoryCli;
	
	//find Car by id
	public Optional<CarroEntity> findCarById(Long id) {
		Optional<CarroEntity> carFind = repository.findById(id);
		if(carFind.isPresent()) {
			return repository.findById(id);
		}else {
			throw new ObjectNotFoundException(id, CarroEntity.class.getName());
		}
	
	}
	
	//find all Cars
	
	public List<CarroEntity> findAllCars(){
		return repository.findAll();
	}
	
	//Create a Car
	//Associa a um cliente
	public CarroEntity createCar(CarroEntity carro, Long idCli) {
		Optional<ClienteEntity> cliente = repositoryCli.findById(idCli);
		if(carro.getMarca() == null || carro.getMarca().isBlank() 
				|| carro.getModelo() == null || carro.getModelo().isBlank() || carro.getDataCadastro() == null) {
			throw new BadRequestException("Não pode estar vaziu");
		}
		if(cliente.isPresent()) {	
			carro.setCli(cliente.get());
			return repository.save(carro);
		}else {
			//Ao criar um carro associamos a um cliente logo, se não conseguimos achar o cliente 
			// Ocorre a exceção
			throw new ObjectNotFoundException(idCli, ClienteEntity.class.getName());
		}
	}
	
	//Update a Car
	
	public CarroEntity updateCar(CarroEntity carro, Long id){
		Optional<CarroEntity> car = repository.findById(id);
		
		if(carro.getMarca() == null || carro.getMarca().isBlank() 
				|| carro.getModelo() == null || carro.getModelo().isBlank()) {
			throw new BadRequestException("Não pode estar vaziu");
		}
		
		if(car.isPresent()) {
			 var carroAtu = car.get();
			 carroAtu.setMarca(carro.getMarca());
			 carroAtu.setModelo(carro.getModelo());
			 repository.save(carroAtu);
			 return carroAtu;
		}else {
			throw new ObjectNotFoundException(id, CarroEntity.class.getName());
		}
		
	}
	
	//Delete a car
	
	public String deleteCar(Long id) {
		Optional<CarroEntity> carro = repository.findById(id);
		if(carro.isPresent()) {
			repository.deleteById(id);
			return "Carro deletado com sucesso!!";
		}else {
			throw new ObjectNotFoundException(id, CarroEntity.class.getName());
		}
	}
	
	
}