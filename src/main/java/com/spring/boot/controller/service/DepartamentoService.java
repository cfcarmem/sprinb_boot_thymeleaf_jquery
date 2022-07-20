package com.spring.boot.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.boot.entity.Departamento;
import com.spring.boot.repository.DepartamentoRepository;


@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository drepository;
	
	public List<Departamento> findAll(){
		List<Departamento> lista = drepository.findAll();
		return lista;
	}
	
	public  Optional<Departamento> getFindId(Long Id){
		return drepository.findById(Id);
		
	}
	
	public void salvar(Departamento depto) {
		drepository.save(depto);
	}
	
	public void updateDepartamento(Departamento depto) {
		drepository.save(depto);
	}
	public  void deleteDepartamento(Long id) {
		drepository.deleteById(id);
	}
	

}
