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

import com.projetojpa.entities.Drogaria;
import com.projetojpa.services.DrogariaServices;



@RestController
@RequestMapping("/drogaria")
public class DrogariaController {
	private final DrogariaServices drogariaServices;
	
	@Autowired
	public DrogariaController (DrogariaServices drogariaServices) {
		this.drogariaServices = drogariaServices;
	}
	@GetMapping("/{id}")
	public ResponseEntity <Drogaria> buscaDrogariaIdControlId(@PathVariable Long id){
		Drogaria drogaria = drogariaServices.buscaDrogariaId(id);
		if(drogaria != null) {
			return ResponseEntity.ok(drogaria);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Drogaria>> buscaTodasDrogariaControl() {
		List<Drogaria> Drogaria = drogariaServices.buscarTodasDrogaria();

		return ResponseEntity.ok(Drogaria);
	}
	@PostMapping("/")
	public ResponseEntity<Drogaria> salvaDrogariaControl(@RequestBody Drogaria drogaria){
		Drogaria salvaDrogaria = drogariaServices.salvaDrogaria(drogaria);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvaDrogaria);

	}
	@PutMapping ("/{id}")
	public ResponseEntity<Drogaria> updateDrogaria(@PathVariable Long id, @RequestBody Drogaria drogaria) {
		Drogaria  updateDrogaria = drogariaServices.alterarDrogaria(id,drogaria);
		if (updateDrogaria  != null) {
			return ResponseEntity.ok(updateDrogaria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaDrogariaControl(@PathVariable Long id) {
		boolean apagar = drogariaServices.apagarDrogaria(id);
		if(apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}

