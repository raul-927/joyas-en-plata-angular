package uy.com.jep.domains;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="impuesto")
public class Impuesto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int impuestoId;
	private String impuestoDesc;
	private String impuestoDescAbrv;
	private BigDecimal impuestoValor;
	private String impuestoTipo;
	
	@OneToOne
	private Cuentas impuestoCuenta;
	
	public int getImpuestoId() {
		return impuestoId;
	}
	public void setImpuestoId(int impuestoId) {
		this.impuestoId = impuestoId;
	}
	public String getImpuestoDesc() {
		return impuestoDesc;
	}
	public void setImpuestoDesc(String impuestoDesc) {
		this.impuestoDesc = impuestoDesc;
	}
	public String getImpuestoDescAbrv() {
		return impuestoDescAbrv;
	}
	public void setImpuestoDescAbrv(String impuestoDescAbrv) {
		this.impuestoDescAbrv = impuestoDescAbrv;
	}
	public BigDecimal getImpuestoValor() {
		return impuestoValor;
	}
	public void setImpuestoValor(BigDecimal impuestoValor) {
		this.impuestoValor = impuestoValor;
	}
	public String getImpuestoTipo() {
		return impuestoTipo;
	}
	public void setImpuestoTipo(String impuestoTipo) {
		this.impuestoTipo = impuestoTipo;
	}
	public Cuentas getImpuestoCuenta() {
		return impuestoCuenta;
	}
	public void setImpuestoCuenta(Cuentas impuestoCuenta) {
		this.impuestoCuenta = impuestoCuenta;
	}

}
