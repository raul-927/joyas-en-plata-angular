package uy.com.jep.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import uy.com.jep.annotations.Cedula;
import uy.com.jep.domains.NroVerifCedula;


public class ValidoCedula extends NroVerifCedula implements ConstraintValidator<Cedula, Integer>{
	
	@Override
	public void initialize(Cedula constraintAnnotation) {
		
	
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		
		return this.nroCedula(value);
	}
	
	
}
