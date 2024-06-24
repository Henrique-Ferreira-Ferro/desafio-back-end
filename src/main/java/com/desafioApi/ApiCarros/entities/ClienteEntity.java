package com.desafioApi.ApiCarros.entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Length(max = 50, message = "O nome pode ter no máximo 50 caracteres")
	private String nome;
	@CPF
	private String cpf;

	@OneToMany(mappedBy = "cli")
	private List<CarroEntity> carro;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate create_at;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate update_at;

	public ClienteEntity() {

	}

	public ClienteEntity(@Length(max = 50, message = "O nome pode ter no máximo 50 caracteres") String nome,
			@CPF String cpf, LocalDate dataNascimento, LocalDate create_at, LocalDate update_at) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<CarroEntity> getCarro() {
		return carro;
	}

	public void setCarro(List<CarroEntity> carro) {
		this.carro = carro;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getCreate_at() {
		return create_at;
	}

	public void setCreate_at(LocalDate create_at) {
		this.create_at = create_at;
	}

	public LocalDate getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(LocalDate update_at) {
		this.update_at = update_at;
	}

}
