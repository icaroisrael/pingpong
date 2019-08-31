package com.br.eeep.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.br.eeep.model.Aluno;
import com.br.eeep.repository.AlunoRepository;



@Controller
public class ControllerCadastro {
	@Autowired
	private AlunoRepository alunoRepository;	
	
	@GetMapping("/")
	public String home(Model model,@RequestParam(defaultValue="0") int page){
		model.addAttribute("alunos", alunoRepository.findAll(new PageRequest(page,5)));
		model.addAttribute("currentPage", page);
		return "listarAlunos";
    }
	
	@PostMapping("/save")
    public String cadastro(Aluno aluno){		
		alunoRepository.save(aluno);
		return "redirect:/";
    }
	
	@GetMapping("/delete")
    public String deleteAluno(Integer id){		
		alunoRepository.deleteById(id);
		return "redirect:/";
    }
	
	@GetMapping("/findOne")
	@ResponseBody
    public String findOne(Integer id) {	
		alunoRepository.findById(id);
		return "redirect:/";
    }

}
