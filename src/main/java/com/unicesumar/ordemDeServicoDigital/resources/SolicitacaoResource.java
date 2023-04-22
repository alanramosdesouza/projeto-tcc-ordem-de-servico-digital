package com.unicesumar.ordemDeServicoDigital.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicesumar.ordemDeServicoDigital.entities.Solicitacao;
import com.unicesumar.ordemDeServicoDigital.services.SolicitacaoService;

@RestController
@RequestMapping(value = "/solicitacoes")
public class SolicitacaoResource {
	
	@Autowired
	private SolicitacaoService service;
	@GetMapping
	public ResponseEntity<List<Solicitacao>> findALL(){
		List<Solicitacao> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Solicitacao> findById(@PathVariable Long id){
		Solicitacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
