package com.spring.boot.controller;

import java.util.List;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.controller.service.FuncionarioService;
import com.spring.boot.controller.service.ProjetoFuncionarioService;
import com.spring.boot.controller.service.ProjetoService;
import com.spring.boot.entity.Funcionario;
import com.spring.boot.entity.Projeto;
import com.spring.boot.entity.ProjetoFuncionario;
import com.spring.boot.entity.pk.ProjetoFuncionarioPK;

@RestController
@RequestMapping("/equipe")
public class ProjetoFuncionarioController {
	

	  @Autowired
	   private ProjetoFuncionarioService fservice;
	  
	  
	  @Autowired
	   private ProjetoService pservice;
	
	  
	  @Autowired
	   private FuncionarioService funcservice;
	  
	  
	   @GetMapping("")
	   @ResponseBody
	   public ResponseEntity<List<Funcionario>>listarEquipe(){
		   List<Funcionario> f =  fservice.listarTodos();
		   return new ResponseEntity<List<Funcionario>>(f, HttpStatus.OK);
		 //  return null;
	   }
	   
	   

	  //buscando equipe a pargir do getProjetos que está na classe projetos
	   @GetMapping(value="/{id}")
	   @ResponseBody //recebe o id em JSON e retorna um JSON
	   public ResponseEntity<Set<Funcionario>>buscarPorId(@PathVariable(value="id") Long id){
		  Projeto p = pservice.findId(id);
		  Set<Funcionario> lista = p.getProjetos();
		  return new ResponseEntity<Set<Funcionario>>(lista,HttpStatus.OK);
//		 / return null;
	   }
	   
	   
	   @PostMapping("/{idfuncionario}/{idprojeto}")
	   @ResponseBody
	   public ResponseEntity<String>adicionar(@PathVariable Long idfuncionario,@PathVariable Long idprojeto){
		   //vamos buscar a classe projeto
		   Projeto p = pservice.findId(idprojeto);
		   //vamos buscar a classe funcionario
		   Funcionario f =  funcservice.buscarPorId(idfuncionario);
		   ProjetoFuncionario pf = new ProjetoFuncionario(f,p);
		   fservice.salvar(pf);
		   return   new ResponseEntity<String>("Adicionado com sucesso",HttpStatus.CREATED);
//		/   return null;
		   
		   
	   }
	   
	   
	   @DeleteMapping("/{idfuncionario}/{idprojeto}")
	   @ResponseBody
	   public ResponseEntity<String>deletar(@PathVariable Long idfuncionario,@PathVariable Long idprojeto){
		   //vamos buscar a classe projeto
		   Projeto p = pservice.findId(idprojeto);
		   //vamos buscar a classe funcionario
		   Funcionario f =  funcservice.buscarPorId(idfuncionario);
		   ProjetoFuncionario pf = new ProjetoFuncionario(f,p);
		   fservice.deletar(pf);
		   return   new ResponseEntity<String>("Deletado com sucesso",HttpStatus.CREATED);
//		/   return null;
		   
		   
	   }
	   
 	   
}
