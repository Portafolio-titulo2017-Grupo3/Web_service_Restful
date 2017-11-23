package com.portafolio2017.rest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio2017.rest.entity.Funcionario;

@Repository("funcionarioRepository")
public interface FuncionarioRepository extends JpaRepository<Funcionario, Serializable> {

	
	public abstract Funcionario findByRutFuncionario(String rut);
}
