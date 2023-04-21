package com.unicesumar.ordemDeServicoDigital.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unicesumar.ordemDeServicoDigital.entities.User;
import com.unicesumar.ordemDeServicoDigital.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "12345", "Fernanda", "Noite");
		User u2 = new User(null, "123456", "Marco Machado", "Manhã"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}

}
