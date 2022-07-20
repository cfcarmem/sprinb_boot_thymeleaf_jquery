package com.spring.boot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.boot.entity.Funcionario;
import com.spring.boot.entity.Projeto;
import com.spring.boot.entity.ProjetoFuncionario;


@Repository
@Transactional
public interface ProjetoFuncionarioRepository extends JpaRepository<ProjetoFuncionario, Long> {

}
