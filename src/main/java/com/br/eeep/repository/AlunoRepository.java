package com.br.eeep.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.eeep.model.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	//List<Aluno> findBySexo(String sexo);
	@Query("from Aluno where sexo = 'F' ")
	List<Aluno> findByFeminino();	
	
	@Query("from Aluno where turma like concat(?1, '%') AND sexo like concat(?2, '%') ")
	List<Aluno> findByTerceiro(String turma, String sexo);
	
	@Query("from Aluno where turma like concat(?1, '%') OR turma like concat(?2, '%') AND sexo like concat(?3, '%') ")
	List<Aluno> findByTodos(String turma1, String turma2, String sexo);	
	
	
	

}
