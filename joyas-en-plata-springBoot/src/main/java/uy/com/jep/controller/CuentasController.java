package uy.com.jep.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uy.com.jep.domains.Cuentas;
import uy.com.jep.services.CuentasService;

@RestController
@CrossOrigin(origins = "*")
public class CuentasController {
	
	@Autowired
	private CuentasService cuentasService;
	
	
	@RequestMapping(value ="/cuenta", method =RequestMethod.POST, 
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Cuentas> insertCuenta(@RequestBody @Valid Cuentas cuenta, BindingResult bindingResult){
		HttpHeaders httpHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Cuentas>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.cuentasService.insertCuenta(cuenta);
		return new ResponseEntity<Cuentas>(cuenta, httpHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/cuenta", method =RequestMethod.PUT, 
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Cuentas> updateCuenta(@RequestBody @Valid Cuentas cuenta, BindingResult bindingResult){
		HttpHeaders httpHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Cuentas>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.cuentasService.updateCuenta(cuenta);
		return new ResponseEntity<Cuentas>(cuenta, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/cuenta/{cuentaId}", method =RequestMethod.DELETE, 
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Cuentas> deleteCuenta(@PathVariable int cuentaId){
		HttpHeaders httpHeaders = new HttpHeaders();
		Cuentas cuenta = this.cuentasService.getCuentaByCuentaId(cuentaId);
		this.cuentasService.deleteCuenta(cuentaId);
		return new ResponseEntity<Cuentas>(cuenta, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/cuenta/{cuentaId}", method =RequestMethod.GET, 
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Cuentas> getCuentaByCuentaId(@PathVariable int cuentaId){
		HttpHeaders httpHeaders = new HttpHeaders();
		Cuentas cuenta = this.cuentasService.getCuentaByCuentaId(cuentaId);
		return new ResponseEntity<Cuentas>(cuenta, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/cuentas", method =RequestMethod.GET, 
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Cuentas>> listAllCuentas(){
		HttpHeaders httpHeaders = new HttpHeaders();
		List<Cuentas> cuentas = this.cuentasService.listAllCuentas();
		return new ResponseEntity<List<Cuentas>>(cuentas, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/cuentas/{grupoCuentaId}", method =RequestMethod.GET, 
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Cuentas>> listCuentasByGrupoCuentaId(@PathVariable int grupoCuentaId){
		HttpHeaders httpHeaders = new HttpHeaders();
		List<Cuentas> cuentas = this.cuentasService.listCuentasByGrupoCuentaId(grupoCuentaId);
		return new ResponseEntity<List<Cuentas>>(cuentas, httpHeaders, HttpStatus.OK);
	}
	
	

}
