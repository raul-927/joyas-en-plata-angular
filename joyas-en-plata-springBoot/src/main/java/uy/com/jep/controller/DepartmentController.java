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

import uy.com.jep.domains.Department;
import uy.com.jep.services.DepartmentService;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {
	
	
	@Autowired
	private DepartmentService departmenService;
	
	
	
	@RequestMapping(value ="/departments", method =RequestMethod.POST, 
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Department> insertDepartment(@RequestBody @Valid Department department, BindingResult bindingResult){
		HttpHeaders httpHeaders = new HttpHeaders();
		
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Department>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.departmenService.insert(department);
		return new ResponseEntity<Department>(department, httpHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/departments", method =RequestMethod.PUT, 
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department, BindingResult bindingResult){
		HttpHeaders httpHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Department>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.departmenService.update(department);
		return new ResponseEntity<Department>(department, httpHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/departments/{id}", method =RequestMethod.DELETE, 
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Department> deleteDepartment(@PathVariable int id){
		HttpHeaders httpHeaders = new HttpHeaders();
		if(id > 0){
			this.departmenService.delete(id);
		}
		return new ResponseEntity<Department>(null, httpHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/departments", method =RequestMethod.GET, 
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Department>> listAllDepartment(){
		HttpHeaders httpHeaders = new HttpHeaders();
		List<Department> departments = this.departmenService.listAllDepartments();
		return new ResponseEntity<List<Department>>(departments, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/departments/{id}", method =RequestMethod.GET, 
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Department> listDepartmentById(@PathVariable int id){
		HttpHeaders httpHeaders = new HttpHeaders();
		Department department = this.departmenService.listDepartmentById(id);
		
		return new ResponseEntity<Department>(department, httpHeaders, HttpStatus.OK);
	}
	
}
