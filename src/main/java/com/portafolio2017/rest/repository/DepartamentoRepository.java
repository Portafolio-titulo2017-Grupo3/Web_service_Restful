package com.portafolio2017.rest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio2017.rest.entity.Departamento;

@Repository("departamentoRepository")
public interface DepartamentoRepository extends JpaRepository<Departamento, Serializable> {
	
	public abstract Departamento findByIdDepto(int IdDepto);

}
