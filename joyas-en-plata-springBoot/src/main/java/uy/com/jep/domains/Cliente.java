package uy.com.jep.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import uy.com.jep.annotations.Cedula;
import uy.com.jep.annotations.CedulaExistente;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String apellido;
	
	@Id
	@Digits(message ="Debe ingresar unicamente numeros", fraction = 0, integer = 8)
	@Max(value=99999999, message ="ERROR; Ingrse un maximo de 8 digitos")
	@NotNull(message ="ERROR; Debe ingresar un nro de cedula valido")
	@Min(value=1111111, message ="ERROR; Ingrese un valor mayor a 6 digitos")
	@Cedula(message ="Cedula Invalida")
	@CedulaExistente(message="Cedula ya ingresada en el sistema")
	private int cedula;
	private String 	ocupacion;
	private String	sociedadMedica;
	private String	emergenciaMovil;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public String getSociedadMedica() {
		return sociedadMedica;
	}
	public void setSociedadMedica(String sociedadMedica) {
		this.sociedadMedica = sociedadMedica;
	}
	public String getEmergenciaMovil() {
		return emergenciaMovil;
	}
	public void setEmergenciaMovil(String emergenciaMovil) {
		this.emergenciaMovil = emergenciaMovil;
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
