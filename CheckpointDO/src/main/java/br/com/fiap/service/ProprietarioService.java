package br.com.fiap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.model.Proprietario;
import br.com.fiap.repository.ProprietarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioService {

	private final ProprietarioRepository proprietarioRepository;

	@Autowired
	public ProprietarioService(ProprietarioRepository proprietarioRepository) {
		this.proprietarioRepository = proprietarioRepository;
	}

	public List<Proprietario> findAll() {
		return proprietarioRepository.findAll();
	}

	public Optional<Proprietario> findById(Long id) {
		return proprietarioRepository.findById(id);
	}

	public Proprietario save(Proprietario proprietario) {
		return proprietarioRepository.save(proprietario);
	}

	public void deleteById(Long id) {
		proprietarioRepository.deleteById(id);
	}
}
