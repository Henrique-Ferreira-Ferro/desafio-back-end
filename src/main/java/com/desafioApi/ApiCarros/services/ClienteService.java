package com.desafioApi.ApiCarros.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioApi.ApiCarros.entities.ClienteEntity;
import com.desafioApi.ApiCarros.repositores.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;


	// Implementando o CRUD

	// find user by ID

	public Optional<ClienteEntity> findClientbyId(Long id) {
		Optional<ClienteEntity> cliFind = repository.findById(id);
		if(cliFind.isPresent()) {
			return repository.findById(id);
		}else {
			throw new ObjectNotFoundException(id,ClienteEntity.class.getName());
		}
		
	}

	// Find all users
	public List<ClienteEntity> findAllUser() {
		return repository.findAll();
	}

	// Create User
	public ClienteEntity createUser(ClienteEntity cliente) {
		cliente.setCreate_at(LocalDate.now());
		cliente.setUpdate_at(LocalDate.now());
		return repository.save(cliente);
	}

	// Update User
	public ClienteEntity updateUser(ClienteEntity cliente, Long id) {
		Optional<ClienteEntity> clien = repository.findById(id);
		if (clien.isPresent()) {
			ClienteEntity cliMod = clien.get();
			cliMod.setNome(cliente.getNome());
			cliMod.setCpf(cliente.getCpf());
			cliMod.setDataNascimento(cliente.getDataNascimento());
			cliMod.setCarro(cliente.getCarro());
			cliMod.setUpdate_at(LocalDate.now());
			return repository.save(cliMod);
		} else {
			throw new ObjectNotFoundException(id, ClienteEntity.class.getSimpleName());
		}

	}

	// Delete user
	public String deleteUser(Long id) {
		Optional<ClienteEntity> clie = repository.findById(id);
		if (clie.isPresent()) {
			ClienteEntity cl = clie.get();
			repository.deleteById(id);
			return "Usuario " + cl.getNome() + " deletado com sucesso";
		} else {
			throw new ObjectNotFoundException(id,ClienteEntity.class.getSimpleName());
		}
	}

}