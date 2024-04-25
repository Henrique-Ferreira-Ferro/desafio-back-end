package com.desafioApi.ApiCarros.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CarroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String marca;
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private ClienteEntity cli;
	private String modelo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	public CarroEntity() {
		
	}

	public CarroEntity(String marca, String modelo, LocalDate dataCadastro) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.dataCadastro = dataCadastro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	
}
