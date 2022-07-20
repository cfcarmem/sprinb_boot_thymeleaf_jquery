package com.spring.boot.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.entity.enumerator.StatusProjeto;

@RestController
@RequestMapping("/status")
public class StatusProjetoController {
	
	//ao cadastrar, mostrar os gestores no combo
	   @GetMapping("/")
	   @ResponseBody
	   public ResponseEntity<Set<StatusProjeto>>listarStatus(){
		  Set<StatusProjeto> st = new LinkedHashSet<>();
		  for(StatusProjeto p : StatusProjeto.values()) {
			  st.add(p);
		  }
		  return new ResponseEntity<Set<StatusProjeto>>(st, HttpStatus.OK);
	   }
}
