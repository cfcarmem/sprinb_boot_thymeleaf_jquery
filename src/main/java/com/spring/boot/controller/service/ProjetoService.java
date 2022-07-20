package com.spring.boot.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.entity.Funcionario;
import com.spring.boot.entity.Projeto;
import com.spring.boot.entity.pk.ProjetoFuncionarioPK;
import com.spring.boot.repository.ProjetoRepository;


@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository prepository;
	@Autowired
	
	public List<Projeto> findAll(){
		return prepository.findAll();
	}
	
	public Projeto salvar(Projeto projeto) {
		return  prepository.save(projeto);
	}
	
	public Projeto salvarFlush(Projeto projeto) {
		return  prepository.saveAndFlush(projeto);
	}
	
	
	public Projeto findId(Long id) {
		Optional<Projeto> obj = prepository.findById(id);
		return obj.get();
	}
	
}
