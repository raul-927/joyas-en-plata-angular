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

import uy.com.jep.domains.Impuesto;
import uy.com.jep.services.ImpuestoService;

@RestController
@CrossOrigin(origins = "*")
public class ImpuestoController {

	@Autowired
	private ImpuestoService impuestoService;
	
	
	@RequestMapping(value ="/impuesto", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Impuesto> insertImpuesto(@RequestBody @Valid Impuesto impuesto, BindingResult bindingResult){
		HttpHeaders httpHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Impuesto>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.impuestoService.insertImpuesto(impuesto);
		return new ResponseEntity<Impuesto>(impuesto, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/impuesto", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Impuesto> updateImpuesto(@RequestBody @Valid Impuesto impuesto, BindingResult bindingResult){
		HttpHeaders httpHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Impuesto>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.impuestoService.updateImpuesto(impuesto);
		return new ResponseEntity<Impuesto>(impuesto, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/impuesto/{impuestoId}", method =RequestMethod.DELETE,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Impuesto> deleteImpuesto(@PathVariable int impuestoId){
		HttpHeaders httpHeaders = new HttpHeaders();
		this.impuestoService.deleteImpuesto(impuestoId);
		return new ResponseEntity<Impuesto>(null, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/impuesto/{impuestoId}", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Impuesto> getImpuestoById(final int id){
		HttpHeaders httpHeaders = new HttpHeaders();
		Impuesto impuesto = this.impuestoService.getImpuestoById(id);
		return new ResponseEntity<Impuesto>(impuesto,httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/impuestos", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Impuesto>> listAllImpuestos(){
		HttpHeaders httpHeaders = new HttpHeaders();
		List<Impuesto> impuestos = this.impuestoService.listAllImpuestos();
		return new ResponseEntity<List<Impuesto>>(impuestos,httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/impuestos/{id}", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Impuesto>> listImpuestoByCuentaId(@PathVariable int id){
		HttpHeaders httpHeaders = new HttpHeaders();
		List<Impuesto> impuestos = this.impuestoService.listImpuestoByCuentaId(id);
		return new ResponseEntity<List<Impuesto>>(impuestos,httpHeaders, HttpStatus.OK);
	}
}
