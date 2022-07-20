package com.spring.boot.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.boot.entity.Funcionario;
import com.spring.boot.entity.Projeto;
import com.spring.boot.repository.FuncionarioRepository;


@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository frepository;
	
	public List<Funcionario> listarTodos(){
		return frepository.findAll();
	}
	 
	
	public Funcionario buscarPorId(Long id){
		Optional<Funcionario> obj = frepository.findById(id);
		return  obj.get();
	}
	
	
	public Optional<Funcionario> procurarPorId(Long id){
		return frepository.findById(id);
	}
	
	public void addFunc(Funcionario funcionario) {
		frepository.save(funcionario);
	}
	
	public void deleteFuncId(Long id) {
		frepository.deleteById(id);
	}
	
	public void updateFunc(Funcionario funcionario) {
		frepository.save(funcionario);
	}
	
	public List<Funcionario> fullSearchFunc(String nomepesquisar){
		return  frepository.pesquisaAvancada(nomepesquisar);
	}

}
