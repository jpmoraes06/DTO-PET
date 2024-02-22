package com.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.DTO.PettDTO;
import com.usuario.entities.Pett;
import com.usuario.repository.PettRepository;

@Service
public class PettService {
	private final PettRepository pettRepository;

	@Autowired
	public PettService(PettRepository pettRepository) {
		this.pettRepository = pettRepository;
	}
	public PettDTO salvar(PettDTO pettDTO) {
		Pett pett = new Pett(pettDTO.id(),pettDTO.nome(), pettDTO.cuidador(), pettDTO.nascimento());
		Pett salvarPett = pettRepository.save(pett);
		return new PettDTO(salvarPett.getId(),salvarPett.getNome(),salvarPett.getNascimento(),salvarPett.getCuidador());
	}
		public PettDTO atualizar(Long id, PettDTO pettDTO) {
			Pett existePett = pettRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
			existePett.setNome(pettDTO.nome());
			existePett.setNascimento(pettDTO.nascimento());
			existePett.setCuidador(pettDTO.cuidador());
			
			Pett updatePett = pettRepository.save(existePett);
			return new PettDTO(updatePett.getId(),updatePett.getNome(),updatePett.getNascimento(),updatePett.getCuidador());
		}
		public boolean deletar(Long id) {
			Optional<Pett> existePett = pettRepository.findById(id);
			if(existePett.isPresent()) {
				pettRepository.deleteById(id);
				return true;
			}
			return false;
		}
		public List<Pett> buscarTodos(){
			return pettRepository.findAll();
		}
		public Pett buscarporId(Long id) {
			Optional<Pett> pett = pettRepository.findById(id);
			return pett.orElse(null);
		}
	

}
