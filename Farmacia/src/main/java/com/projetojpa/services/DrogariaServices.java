package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetojpa.entities.Drogaria;
import com.projetojpa.repository.DrogariaRepository;

@Service
public class DrogariaServices {
	private final DrogariaRepository drogariaRepository;

	@Autowired
	public DrogariaServices(DrogariaRepository drogariaRepository) {
		this.drogariaRepository = drogariaRepository;
	}
	public List<Drogaria> buscarTodasDrogaria(){
		return drogariaRepository.findAll();
	}
	//método para buscar produto por código 
	public Drogaria buscaDrogariaId(long id) {
		Optional<Drogaria> Drogaria = drogariaRepository.findById(id); // classe usada para consulta de banco
		return Drogaria.orElse(null);
	} 
	//método para salvar os produtos
	public Drogaria salvaDrogaria(Drogaria drogaria) {
		return drogariaRepository.save(drogaria);
	}
	public Drogaria alterarDrogaria(long id, Drogaria alterarDrogaria) {
		Optional<Drogaria> existeDrogaria = drogariaRepository.findById(id);
		if (existeDrogaria.isPresent()) {
			alterarDrogaria.setId(id);
			return drogariaRepository.save(alterarDrogaria);
		}
		return null;
	}
	public boolean apagarDrogaria(long id) {
		Optional<Drogaria> existeDrogaria = drogariaRepository.findById(id);
		if (existeDrogaria.isPresent()) {
			drogariaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

