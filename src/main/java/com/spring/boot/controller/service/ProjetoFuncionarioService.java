package com.spring.boot.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.entity.Funcionario;
import com.spring.boot.entity.Projeto;
import com.spring.boot.entity.ProjetoFuncionario;
import com.spring.boot.repository.FuncionarioRepository;
import com.spring.boot.repository.ProjetoFuncionarioRepository;

@Service
public class ProjetoFuncionarioService {

	@Autowired
	private FuncionarioRepository frepository;
	
	@Autowired
	private ProjetoFuncionarioRepository fprojfunc;
	
	
	
	public List<Funcionario> listarTodos(){
		return frepository.findAll();
	}
	
	public void salvar(ProjetoFuncionario pf) {
		fprojfunc.save(pf);
	}
	
	
	public void deletar(ProjetoFuncionario pf) {
		fprojfunc.delete(pf);
	}
	
}
