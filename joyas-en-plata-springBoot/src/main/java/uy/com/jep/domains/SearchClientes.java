package uy.com.jep.domains;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class SearchClientes implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@NotNull(message ="ERROR; Debe ingresar un nro de cedula valido")
	@Digits(integer=8, message = "ERROR; Debe ingresar un numero de cedula de 8 digitos", fraction=0)
	private int cedula;
	
	private String nombre;
	private String apellido;
	
	public int getCedula() 
	{
		return cedula;
	}
	public void setCedula(int cedula) 
	{
		
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	

}
