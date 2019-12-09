package com.restfull.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.model.Nota;
import com.restfull.model.NotaEntity;
import com.restfull.service.NotaService;

@RestController()
@RequestMapping("/v1")
public class NotaController {

	@Autowired
	@Qualifier("notaservice")
	NotaService service;

	@PutMapping("/nota")
	public boolean agregarNota(@RequestBody @Valid NotaEntity nota) {
		return service.crearNota(nota);
	}

	@GetMapping()
	public List<Nota> obtenerTodasNotas() {
		return service.obtenerTodasNotas();
	}

	@PostMapping("/nota")
	public boolean actualizarNota(@RequestBody @Valid NotaEntity nota) {
		return service.actualizarNota(nota);
	}

	@DeleteMapping("/nota/{id}/{nombre}")
	public boolean borrarNota(@PathVariable("id") long id, @PathVariable("nombre") String nombre) {
		return service.borrarNota(nombre, id);
	}
}
