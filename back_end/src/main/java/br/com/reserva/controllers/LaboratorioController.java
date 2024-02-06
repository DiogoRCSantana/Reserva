package br.com.reserva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.reserva.data.vo.LaboratorioVO;
import br.com.reserva.facade.Facade;

@RestController
@RequestMapping("api/laboratorio")
public class LaboratorioController {
	
	@Autowired
	Facade facade;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<LaboratorioVO> getTodosLabs() {
		return facade.getAllLab();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public LaboratorioVO getLab(@PathVariable(value = "id") long id) {
		return facade.getByIdLab(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public LaboratorioVO create(@RequestBody LaboratorioVO lab) {
		return facade.createLab(lab);
	}
	
	@PutMapping
	public LaboratorioVO putMethodName(@RequestBody LaboratorioVO lab) {
		return facade.updateLab(lab);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Long id) {
		facade.deleteLab(id);
	}

}
