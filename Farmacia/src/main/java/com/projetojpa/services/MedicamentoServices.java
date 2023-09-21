package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Medicamento;
import com.projetojpa.repository.MedicamentoRepository;

@Service
public class MedicamentoServices {
	private final MedicamentoRepository medicamentoRepository;

	@Autowired
	public MedicamentoServices(MedicamentoRepository medicamentoRepository) {
		this.medicamentoRepository = medicamentoRepository;
	}
	public List<Medicamento> buscarTodosMedicamento(){
		return medicamentoRepository.findAll();
	}
	//método para buscar produto por código 
	public Medicamento buscaMedicamentoId(long id) {
		Optional<Medicamento> Medicamento = medicamentoRepository.findById(id); // classe usada para consulta de banco
		return Medicamento.orElse(null);
	} 
	//método para salvar os produtos
	public Medicamento salvaMedicamento(Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}
	public Medicamento alterarMedicamento(long id, Medicamento alterarMedicamento) {
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(id);
		if (existeMedicamento.isPresent()) {
			alterarMedicamento.setId(id);
			return medicamentoRepository.save(alterarMedicamento);
		}
		return null;
	}
	public boolean apagarMedicamento(long id) {
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(id);
		if (existeMedicamento.isPresent()) {
			medicamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

