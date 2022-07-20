package com.spring.boot.repository;

import java.util.List;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.boot.entity.Projeto;


@Repository
@Transactional
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
