package com.unicesumar.ordemDeServicoDigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicesumar.ordemDeServicoDigital.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
