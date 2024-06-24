package com.desafioApi.ApiCarros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioApi.ApiCarros.entities.CarroEntity;
import com.desafioApi.ApiCarros.entities.ClienteEntity;
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
		return repository.findById(id);
	}
	
	//find all Cars
	
	public List<CarroEntity> findAllCars(){
		return repository.findAll();
	}
	
	//Create a Car
	//Associa a um cliente
	public CarroEntity createCar(CarroEntity carro, Long idCli) {
		Optional<ClienteEntity> cliente = repositoryCli.findById(idCli);
		if(cliente.isPresent()) {
			carro.setCli(cliente.get());
			return repository.save(carro);
		}else {
			throw new RuntimeException("O cliente não foi encontrado, ou há informações pendentes para o carro!");
		}
	}
	
	//Update a Car
	
	public CarroEntity updateCar(CarroEntity carro, Long id){
		Optional<CarroEntity> car = repository.findById(id);
		if(car.isPresent()) {
			 var carroAtu = car.get();
			 carroAtu.setMarca(carro.getMarca());
			 carroAtu.setModelo(carro.getModelo());
			 repository.save(carroAtu);
			 return carroAtu;
		}else {
			throw new RuntimeException("Carro não encontrado!");
		}
		
	}
	
	//Delete a car
	
	public String deleteCar(Long id) {
		Optional<CarroEntity> carro = repository.findById(id);
		CarroEntity car = carro.get();
		if(carro.isPresent()) {
			repository.deleteById(id);
			return "Carro "+car.getModelo() +" deletado com sucesso!!";
		}else {
			return "Carro não encontrado no sistema";
		}
	}
	
	
}