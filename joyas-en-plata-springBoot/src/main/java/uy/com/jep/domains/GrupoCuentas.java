package uy.com.jep.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="grupo_cuentas")
@NotNull(message = "No debe ser null")
public class GrupoCuentas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int grupoCuentaId;
	private	String tipoCuenta;
	private String grupoCuentaDesc;
	
	public int getGrupoCuentaId() {
		return grupoCuentaId;
	}
	public void setGrupoCuentaId(int grupoCuentaId) {
		this.grupoCuentaId = grupoCuentaId;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getGrupoCuentaDesc() {
		return grupoCuentaDesc;
	}
	public void setGrupoCuentaDesc(String grupoCuentaDesc) {
		this.grupoCuentaDesc = grupoCuentaDesc;
	}
	
}
