package com.portafolio2017.rest.service;

import java.util.List;

import com.portafolio2017.rest.entity.Departamento;
import com.portafolio2017.rest.model.DepartamentoModel;



public interface DepartamentoService {

	public abstract Departamento findDepartamentoByIdDepto(int idDepto);
	
	public abstract DepartamentoModel findDepartamentoModelByIdDepto(int idDepto);
	
	public abstract List<DepartamentoModel> findAllDepartamentoModel();
	
	
}
