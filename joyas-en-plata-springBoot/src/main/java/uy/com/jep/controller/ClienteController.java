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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uy.com.jep.domains.Cliente;
import uy.com.jep.services.ClienteService;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	@RequestMapping(value ="/clientes", method =RequestMethod.GET, 
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Cliente>> getAllClientes(){
		HttpHeaders responseHeaders = new HttpHeaders();
		List<Cliente> clientes = this.clienteService.findAllClientes();
		
		return new ResponseEntity<List<Cliente>>(clientes,responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/cliente", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Cliente>> insertCliente(@RequestBody @Valid Cliente cliente, BindingResult bindingResult){
		HttpHeaders responseHeaders = new HttpHeaders();
		 
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			return new ResponseEntity<List<Cliente>>(null, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.clienteService.insertCliente(cliente);
		
		List<Cliente> clientes = this.clienteService.findAllClientes();
		
		return new ResponseEntity<List<Cliente>>(clientes, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/cliente", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Cliente> updateCliente(Cliente cliente){
		HttpHeaders responseHeaders = new HttpHeaders();
		this.clienteService.updateCliente(cliente);
		
		return new ResponseEntity<Cliente>(cliente, responseHeaders, HttpStatus.OK);
	}
	
	
	
}
