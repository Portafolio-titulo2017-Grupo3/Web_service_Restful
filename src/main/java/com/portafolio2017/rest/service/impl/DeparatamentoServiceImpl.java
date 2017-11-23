package com.portafolio2017.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.portafolio2017.rest.converter.DepartamentoConverter;
import com.portafolio2017.rest.entity.Departamento;
import com.portafolio2017.rest.model.DepartamentoModel;
import com.portafolio2017.rest.repository.DepartamentoRepository;
import com.portafolio2017.rest.service.DepartamentoService;



@Service("departamentoService")
public class DeparatamentoServiceImpl implements DepartamentoService{

	@Autowired
	@Qualifier("departamentoRepository")
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	@Qualifier("departamentoConverter")
	private DepartamentoConverter departamentoConverter;
	
	@Override
	public Departamento findDepartamentoByIdDepto(int idDepto) {
		return departamentoRepository.findByIdDepto(idDepto);
	}

	@Override
	public DepartamentoModel findDepartamentoModelByIdDepto(int idDepto) {
		return departamentoConverter.convertDepartamento2DepartamentoModel(departamentoRepository.findByIdDepto(idDepto));
	}

	@Override
	public List<DepartamentoModel> findAllDepartamentoModel() {
		List<Departamento> departamentos = departamentoRepository.findAll();
		List<DepartamentoModel> departamentoModel = new ArrayList<DepartamentoModel>();
		
		for(Departamento departamento : departamentos) {
			departamentoModel.add(departamentoConverter.convertDepartamento2DepartamentoModel(departamento));
		}
		return departamentoModel;
	}

	
}
