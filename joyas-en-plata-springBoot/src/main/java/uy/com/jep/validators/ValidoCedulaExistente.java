package uy.com.jep.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import uy.com.jep.annotations.CedulaExistente;
import uy.com.jep.domains.NroVerifCedula;
import uy.com.jep.domains.Cliente;
import uy.com.jep.services.ClienteService;

public class ValidoCedulaExistente extends NroVerifCedula implements ConstraintValidator<CedulaExistente, Integer>{
	
	@Autowired
	private ClienteService clienteService;
	
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context){
		boolean control = true;
		boolean NroVerif = this.nroCedula(value);
		if(NroVerif){
			int cedula = value;
			Cliente cliente = clienteService.findClienteByCedula(cedula);
			try{
				if(cliente !=null){
					control=false;
				}
					
			}
			catch(NullPointerException e){
				control = true;
			}
		}
		return control;
	}	
	@Override
	public void initialize(CedulaExistente constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}
}
