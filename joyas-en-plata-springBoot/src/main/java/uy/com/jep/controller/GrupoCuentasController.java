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

import uy.com.jep.domains.GrupoCuentas;
import uy.com.jep.services.GrupoCuentasService;

@RestController
@CrossOrigin(origins = "*")
public class GrupoCuentasController {

	@Autowired
	private GrupoCuentasService grupoCuentasService;
	
	
	@RequestMapping(value ="/grupoCuenta", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<GrupoCuentas> insertGrupoCuentas(@RequestBody @Valid GrupoCuentas grupoCuentas, BindingResult bindingResult){
		HttpHeaders httpHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			
			return new ResponseEntity<GrupoCuentas>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.grupoCuentasService.insertGrupoCuentas(grupoCuentas);
		return new ResponseEntity<GrupoCuentas>(grupoCuentas, httpHeaders, HttpStatus.OK);
		
	}
	
	@RequestMapping(value ="/grupoCuenta", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<GrupoCuentas> updateGrupoCuentas(@RequestBody @Valid GrupoCuentas grupoCuentas, BindingResult bindingResult){
		HttpHeaders httpHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			
			return new ResponseEntity<GrupoCuentas>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.grupoCuentasService.updateGrupoCuentas(grupoCuentas);
		return new ResponseEntity<GrupoCuentas>(grupoCuentas, httpHeaders, HttpStatus.OK);
		
	}
	
	@RequestMapping(value ="/grupoCuenta/{grupoCuentaId}", method =RequestMethod.DELETE,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<GrupoCuentas> deleteGrupoCuentas(@PathVariable int grupoCuentaId){
		HttpHeaders httpHeaders = new HttpHeaders();
		this.grupoCuentasService.deleteGrupoCuentas(grupoCuentaId);
		return new ResponseEntity<GrupoCuentas>(null, httpHeaders, HttpStatus.OK);
		
	}
	

	@RequestMapping(value ="/grupoCuenta/{grupoCuentaId}", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<GrupoCuentas> getGrupoCuentaByGrupoCuentaId(@PathVariable int grupoCuentaId){
		HttpHeaders httpHeaders = new HttpHeaders();
		GrupoCuentas grupoCuenta = this.grupoCuentasService.getGrupoCuentaByGrupoCuentaId(grupoCuentaId);
		return new ResponseEntity<GrupoCuentas>(grupoCuenta, httpHeaders, HttpStatus.OK);
		
	}
	
	@RequestMapping(value ="/grupoCuenta", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<GrupoCuentas>> listAllGrupoCuentas(){
		HttpHeaders httpHeaders = new HttpHeaders();
		List<GrupoCuentas> grupoCuentas = this.grupoCuentasService.listAllGrupoCuentas();
		return new ResponseEntity<List<GrupoCuentas>>(grupoCuentas, httpHeaders, HttpStatus.OK);
		
	}
}
