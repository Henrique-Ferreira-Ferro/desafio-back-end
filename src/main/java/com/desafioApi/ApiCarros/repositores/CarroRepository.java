package com.desafioApi.ApiCarros.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioApi.ApiCarros.entities.ClienteEntity;

@Repository
public interface CarroRepository extends JpaRepository<ClienteEntity, Long>{

	
}
