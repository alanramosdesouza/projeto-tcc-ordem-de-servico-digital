package com.unicesumar.ordemDeServicoDigital.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unicesumar.ordemDeServicoDigital.entities.Solicitacao;
import com.unicesumar.ordemDeServicoDigital.entities.User;
import com.unicesumar.ordemDeServicoDigital.entities.enums.StatusSolicitacao;
import com.unicesumar.ordemDeServicoDigital.repositories.SolicitacaoRepository;
import com.unicesumar.ordemDeServicoDigital.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "12345", "Fernanda", "Noite", "Recepção");
		User u2 = new User(null, "123456", "Marco Machado", "Manhã", "Recepção"); 
		User u3 = new User(null, "552266", "Antonio", "Manhã", "Manutenção"); 
		
		Solicitacao o1 = new Solicitacao(null, Instant.parse("2019-06-20T19:53:07Z"), StatusSolicitacao.SOLICITACAO_REALIZADA, u1);
		Solicitacao o2 = new Solicitacao(null, Instant.parse("2019-07-21T03:42:10Z"), StatusSolicitacao.SOLICITACAO_ATENDIDA, u3);
		Solicitacao o3 = new Solicitacao(null, Instant.parse("2019-07-22T15:21:22Z"), StatusSolicitacao.SOLICITACAO_CANCELADA, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		solicitacaoRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}

}
