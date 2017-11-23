package com.portafolio2017.rest.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.portafolio2017.rest.model.FuncionarioInfoModel;

@org.springframework.web.bind.annotation.RestController
@Controller
public class RestController {
	
	private static final Log LOG = LogFactory.getLog(RestController.class);
	
	
	@GetMapping("/get")
	public ResponseEntity<String> checkRest(){
		FuncionarioInfoModel cm = new FuncionarioInfoModel();
		return new ResponseEntity<String>("OK!", HttpStatus.OK);
		//return new ResponseEntity<FuncionarioInfoModel>(cm, HttpStatus.OK);
	}
	


}
