package com.portafolio2017.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.portafolio2017.rest.converter.FuncionarioConverter;
import com.portafolio2017.rest.entity.Funcionario;
import com.portafolio2017.rest.model.FuncionarioInfoModel;
import com.portafolio2017.rest.repository.FuncionarioRepository;
import com.portafolio2017.rest.service.FuncionarioService;


@Service("funcionarioService")
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	@Qualifier("funcionarioRepository")
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	@Qualifier("funcionarioConverter")
	private FuncionarioConverter funcionarioConverter;
	
	@Override
	public Funcionario findFuncionarioByRut(String rut) {
		// TODO Auto-generated method stub
		return funcionarioRepository.findByRutFuncionario(rut);
	}

	@Override
	public FuncionarioInfoModel findFuncionarioModelByRut(String rut) {
		// TODO Auto-generated method stub
		return funcionarioConverter.convertFuncionario2FuncionarioModel(funcionarioRepository.findByRutFuncionario(rut));
	}

}
