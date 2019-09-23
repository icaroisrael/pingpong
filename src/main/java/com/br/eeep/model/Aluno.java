package com.br.eeep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno implements Comparable<Aluno> {
	
	@Override public int compareTo(Aluno outroAluno) { 
		if (this.id > outroAluno.getId()) { 
			  return -1; 
			  } if (this.id < outroAluno.getId()) { 
			  return 1; 
			  } 
			  return 0; 
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotNull(message = "nome é obrigatório")
	@Column
	private String nome;
	@NotNull(message = "Turma é obrigatório")
	@Column
	private String turma;
	
	@NotNull(message = "Sexo é obrigatório")
	@Column
	private String sexo;
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int numero) {
		this.id = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
}
