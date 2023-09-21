package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name= "drogaria")
public class Drogaria {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@NotBlank
	@Column(name= "nome")
	private String nome;

	@NotNull
	@NotBlank
	@Size(min= 8, message="Mínimo 8 caracteres")
	@Column(name= "cnpj")
	private String cnpj;

	public long getId() {
		return id;
	}
	public void setId (long id) {
		this.id= id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj=cnpj;
	}
}



