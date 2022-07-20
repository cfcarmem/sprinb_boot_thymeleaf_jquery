package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.controller.service.FuncionarioService;
import com.spring.boot.controller.service.ProjetoFuncionarioService;
import com.spring.boot.entity.Funcionario;
import com.spring.boot.entity.ProjetoFuncionario;

@RestController
@RequestMapping("/pessoas")
public class FuncionarioRestController {

	   @Autowired
	   private FuncionarioService fservice;
	   
	   
	   //ao cadastrar, mostrar os gestores no combo
	   @GetMapping("")
	   @ResponseBody
	   public ResponseEntity<List<Funcionario>>listarGestores(){
		   List<Funcionario> f =  fservice.listarTodos();
		   return new ResponseEntity<List<Funcionario>>(f, HttpStatus.OK);
	   }
	   
	   
	   
	   
	   
}
