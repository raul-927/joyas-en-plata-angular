package uy.com.jep.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uy.com.jep.domains.Product;
import uy.com.jep.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value ="/product", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Product> insertProduct(@RequestBody @Valid Product product, BindingResult bindingResult){
		HttpHeaders httpHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError().getField());
			return new ResponseEntity<Product>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		this.productService.insertProduct(product);
		return new ResponseEntity<Product>(product, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/product", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Product> updateProduct(@RequestBody @Valid Product product, BindingResult bindingResult){
		HttpHeaders httpHeaders = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError().getField());
			return new ResponseEntity<Product>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		this.productService.updateProduct(product);
		return new ResponseEntity<Product>(product, httpHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/product/{id}", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Product> deleteProduct(@PathVariable int id){
		HttpHeaders httpHeaders = new HttpHeaders();
		this.productService.deleteProduct(id);
		return new ResponseEntity<Product>(null, httpHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/product/{id}", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Product> listProductById(@PathVariable int id){
		HttpHeaders httpHeaders = new HttpHeaders();
		Product product = this.productService.listProductById(id);
		return new ResponseEntity<Product>(product, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/product", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Product>> listAllProducts(){
		HttpHeaders httpHeaders = new HttpHeaders();
		List<Product> products = this.productService.listAllProducts();
		return new ResponseEntity<List<Product>>(products, httpHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/product/department/{department_id}", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Product>> listProductByDepartmentId(@PathVariable int department_id){
		HttpHeaders httpHeaders = new HttpHeaders();
		List<Product> products = this.productService.listProductByDepartmentId(department_id);
		return new ResponseEntity<List<Product>>(products, httpHeaders, HttpStatus.OK);
	}
	
}
