package com.portafolio2017.rest.converter;

import org.springframework.stereotype.Component;

import com.portafolio2017.rest.entity.Departamento;
import com.portafolio2017.rest.model.DepartamentoModel;



@Component("departamentoConverter")
public class DepartamentoConverter {
	

	public Departamento convertDepartamentoModel2Departamento(DepartamentoModel departamentoModel) {

		Departamento departamento = new Departamento();
		departamento.setIdDepto(departamentoModel.getIdDepto());
		departamento.setNombreDepto(departamentoModel.getNombreDepto());
		return departamento;
		
	}
	

	public DepartamentoModel convertDepartamento2DepartamentoModel(Departamento departamento) {
		
		DepartamentoModel departamentoModel = new DepartamentoModel();
		departamentoModel.setIdDepto(departamento.getIdDepto());
		departamentoModel.setNombreDepto(departamento.getNombreDepto());
		return departamentoModel;
		
	}
}
