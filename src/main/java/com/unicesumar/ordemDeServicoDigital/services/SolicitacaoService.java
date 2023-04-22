package com.unicesumar.ordemDeServicoDigital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicesumar.ordemDeServicoDigital.entities.Solicitacao;
import com.unicesumar.ordemDeServicoDigital.repositories.SolicitacaoRepository;

@Service
public class SolicitacaoService {
	
	@Autowired
	private SolicitacaoRepository repository;
	
	public List<Solicitacao> findAll(){
		return repository.findAll();
	}
	
	public Solicitacao findById(Long id) {
		Optional<Solicitacao> obj = repository.findById(id);
		return obj.get();
	}

}
