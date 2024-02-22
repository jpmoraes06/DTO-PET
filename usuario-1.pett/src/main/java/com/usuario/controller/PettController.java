package com.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.DTO.PettDTO;
import com.usuario.entities.Pett;
import com.usuario.service.PettService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pet")
public class PettController {
	private final PettService pettService;

	@Autowired
	public PettController(PettService pettservice) {
		this.pettService = pettservice;
	}
	
	@PostMapping
	public ResponseEntity<PettDTO> criar(@RequestBody PettDTO pettDTO) {
		PettDTO salvaPett = pettService.salvar(pettDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaPett);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PettDTO> alterar(@PathVariable Long id, @RequestBody @Valid PettDTO pettDTO) {
		PettDTO alteraPettDTO = pettService.atualizar(id, pettDTO);
		if (alteraPettDTO != null) {
			return ResponseEntity.ok(alteraPettDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pett> apagaPettControl(@PathVariable Long id) {
		boolean apagar = pettService.deletar(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pett> buscaPettControlId(@PathVariable Long id) {
		Pett pett = pettService.buscarporId(id);
		if (pett != null) {
			return ResponseEntity.ok(pett);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Pett>> buscaTodosPettControl() {
		List<Pett> Pett = pettService.buscarTodos();
		return ResponseEntity.ok(Pett);
	}

	
	
	
	

	
}
