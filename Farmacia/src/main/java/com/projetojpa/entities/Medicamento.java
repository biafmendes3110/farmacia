package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name= "medicamento")
public class Medicamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@NotBlank
	@Column(name= "nome")
	private String nome;

	@NotNull
	@NotBlank
	@Column(name= "bula")
	private String bula;
	
	@NotNull
	@NotBlank
	@Column(name= "dataValidade")
	private String dataValidade;

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
	public String getBula() {
		return bula;
	}
	public void setBula(String bula) {
		this.bula=bula;
	}
	
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade=dataValidade;
	}
}

