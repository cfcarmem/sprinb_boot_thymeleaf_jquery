package com.spring.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.entity.Departamento;

@Repository
public interface  DepartamentoRepository extends JpaRepository<Departamento, Long> {
	
}
