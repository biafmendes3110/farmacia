package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Medicamento;
import com.projetojpa.services.MedicamentoServices;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
	private final MedicamentoServices medicamentoServices;

	@Autowired
	public MedicamentoController (MedicamentoServices medicamentoServices) {
		this.medicamentoServices = medicamentoServices;
	}
	@GetMapping("/{id}")
	public ResponseEntity <Medicamento> buscaMedicamentoIdControlId(@PathVariable Long id){
		Medicamento medicamento = medicamentoServices.buscaMedicamentoId(id);
		if(medicamento != null) {
			return ResponseEntity.ok(medicamento);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Medicamento>> buscaTodasMedicamentoControl() {
		List<Medicamento> Medicamento = medicamentoServices.buscarTodosMedicamento();

		return ResponseEntity.ok(Medicamento);
	}
	@PostMapping("/")
	public ResponseEntity<Medicamento> salvaMedicamentoControl(@RequestBody Medicamento medicamento){
		Medicamento salvaMedicamento = medicamentoServices.salvaMedicamento(medicamento);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvaMedicamento);

	}
	@PutMapping ("/{id}")
	public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
		Medicamento updateMedicamento = medicamentoServices.alterarMedicamento(id,medicamento);
		if (updateMedicamento  != null) {
			return ResponseEntity.ok(updateMedicamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaMedicamentoControl(@PathVariable Long id) {
		boolean apagar = medicamentoServices.apagarMedicamento(id);
		if(apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
