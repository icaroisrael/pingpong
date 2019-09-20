package com.br.eeep.controller;






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
		
		List<Aluno> lista = alunoRepository.findByFeminino();
		
		
		
		
		
		
		
		model.addAttribute("masculino", alunoRepository.findByTerceiro("3", "M"));
		model.addAttribute("feminino", alunoRepository.findByFeminino());
		model.addAttribute("todos", alunoRepository.findByTodos("1", "2", "M"));
		return "sorteio";		
    }	
}
