package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
