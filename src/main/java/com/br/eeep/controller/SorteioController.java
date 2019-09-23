package com.br.eeep.controller;






import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.br.eeep.model.Aluno;
import com.br.eeep.repository.AlunoRepository;

@Controller
public class SorteioController {
	@Autowired
	private AlunoRepository alunoRepository;	
	@GetMapping("/sorteio")
	public String getFeminino(Model model){		
		List<Aluno> feminino = alunoRepository.findByFeminino();
		List<Aluno> terceiro = alunoRepository.findByTerceiro("3", "M");
		List<Aluno> todos = alunoRepository.findByTodos("1", "2", "M");
		Collections.sort(feminino);
		Collections.sort(terceiro);
		Collections.sort(todos);		
		model.addAttribute("masculino", terceiro);
		model.addAttribute("feminino", feminino);
		model.addAttribute("todos", todos);
		return "sorteio";		
    }	
}
