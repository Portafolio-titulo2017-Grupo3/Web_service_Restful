package com.portafolio2017.rest.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.portafolio2017.rest.model.FuncionarioInfoModel;
import com.portafolio2017.rest.service.FuncionarioService;
import com.portafolio2017.rest.util.CustomErrorType;

@org.springframework.web.bind.annotation.RestController
@Controller
@RequestMapping("/v1")
public class RestController {
	
	private static final Log LOG = LogFactory.getLog(RestController.class);
	
	@Autowired
	@Qualifier("funcionarioService")
	private FuncionarioService funcionarioService;
	
	
	
	@GetMapping("/funcionario/{rut}&{dias}")
	public ResponseEntity<FuncionarioInfoModel> checkRest2(@PathVariable("rut") String rut,
														  @PathVariable("dias") String dias){
		FuncionarioInfoModel fm = new FuncionarioInfoModel();
		if(rut.isEmpty() || dias.isEmpty()) {
			fm=null;
		}else {
			fm = funcionarioService.findFuncionarioModelByRut(rut);
		}
		
		if (fm == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
		
		int dias_disponibles= fm.getPermisosDisponibles();
		return new ResponseEntity<FuncionarioInfoModel>(fm, HttpStatus.OK);

	}
	
	
	//METODO DE PRUEBA
	@GetMapping("/funcionario2/{rut}&{dias}")
	public ResponseEntity<FuncionarioInfoModel> checkRest(@PathVariable("rut") String rut,
														  @PathVariable("dias") String dias){
		FuncionarioInfoModel fm = new FuncionarioInfoModel();
		if(rut.isEmpty() || dias.isEmpty()) {
			fm=null;
		}else {
			fm = funcionarioService.findFuncionarioModelByRut(rut);
		}
		
		if (fm == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
		
		int dias_disponibles= fm.getPermisosDisponibles();
		
		if(dias_disponibles >= Integer.parseInt(dias)) {
			return new ResponseEntity<FuncionarioInfoModel>(fm, HttpStatus.OK);
		}else {
			return new ResponseEntity(new CustomErrorType("No puede solicitar un permiso que exceda el límite de días disponibles - Días Disponibles: " + 
					dias_disponibles + " Días Solicitados: "+ dias),HttpStatus.FAILED_DEPENDENCY);
		}
		
		//return new ResponseEntity<String>("OK!- GET", HttpStatus.OK);
		//return new ResponseEntity<FuncionarioInfoModel>(fm, HttpStatus.OK);
	}
	
	
	
	
	

	


}
