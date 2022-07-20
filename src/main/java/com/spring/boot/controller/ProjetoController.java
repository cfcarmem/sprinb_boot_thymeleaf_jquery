package com.spring.boot.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.controller.service.FuncionarioService;
import com.spring.boot.controller.service.ProjetoService;
import com.spring.boot.entity.Funcionario;
import com.spring.boot.entity.Projeto;
import com.spring.boot.entity.enumerator.StatusProjeto;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;


@RestController
@RequestMapping("/projetos")
public class ProjetoController {
	
	private static SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
	@Autowired
    private ProjetoService pservice;
	
	@Autowired
	private FuncionarioService fservice;
    
   @GetMapping("")
   @ResponseBody
   public ResponseEntity<List<Projeto>>listarTodos(){
	   List<Projeto> lista = pservice.findAll();
	   return new ResponseEntity<List<Projeto>>(lista, HttpStatus.OK);
   }
   
   //@PostMapping("/buscarId") //buscar por id para carregar a tela de edição
   @GetMapping(value="/{id}")
   @ResponseBody //recebe o id em JSON e retorna um JSON
   public ResponseEntity<Projeto> buscarPorId(@PathVariable Long id){
	   Projeto p = pservice.findId(id);
	   return new ResponseEntity<Projeto>(p, HttpStatus.OK);
   }
   
   
   @PostMapping("")
   @ResponseBody
   public ResponseEntity<Projeto>addprojeto(@RequestBody Projeto projeto){
	   Projeto p =  pservice.salvarFlush(projeto);
	   return new ResponseEntity<Projeto>(p, HttpStatus.CREATED);
   }
   
   @PutMapping("")
   @ResponseBody
   public ResponseEntity<Projeto>alterarProjeto(@RequestBody Projeto projeto){
	   Projeto p =  pservice.salvarFlush(projeto);
	   return new ResponseEntity<Projeto>(p, HttpStatus.CREATED);
   }
   


}
