package com.spring.boot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.entity.Funcionario;

@Repository
@Transactional
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	@Query("select p from Funcionario p where p.nome like %?1% ")
	public List<Funcionario> pesquisaAvancada(String pesquisar);
	
	
}
