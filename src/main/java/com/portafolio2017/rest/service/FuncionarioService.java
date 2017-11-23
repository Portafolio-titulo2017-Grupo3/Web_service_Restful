package com.portafolio2017.rest.service;

import com.portafolio2017.rest.entity.Funcionario;
import com.portafolio2017.rest.model.FuncionarioInfoModel;

public interface FuncionarioService {

	public abstract Funcionario findFuncionarioByRut(String rut);
	public abstract FuncionarioInfoModel findFuncionarioModelByRut(String rut);
	
}
