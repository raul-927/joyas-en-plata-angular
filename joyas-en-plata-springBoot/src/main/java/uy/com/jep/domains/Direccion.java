package uy.com.jep.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="direccion")
public class Direccion implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int 	id;
	private String 	tipoVivienda;
	private String 	calle;
	private int 	nroPuerta;
	private int 	nroAp;
	private String 	calle1;
	private String 	calle2;
	
	@ManyToMany
	private List<Cliente> cliente;
	
	
	
	public Direccion()
	{
		
	}
	
	public Direccion(int dirId, String tipoVivienda, String calle, int nroPuerta, int nroAp, String calle1, String calle2,List<Cliente> cliente) 
	{
		this.id = dirId;
		this.tipoVivienda = tipoVivienda;
		this.calle = calle;
		this.nroPuerta = nroPuerta;
		this.nroAp = nroAp;
		this.calle1 = calle1;
		this.calle2 = calle2;
		this.cliente = cliente;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoVivienda() {
		return tipoVivienda;
	}

	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNroPuerta() {
		return nroPuerta;
	}

	public void setNroPuerta(int nroPuerta) {
		this.nroPuerta = nroPuerta;
	}

	public int getNroAp() {
		return nroAp;
	}

	public void setNroAp(int nroAp) {
		this.nroAp = nroAp;
	}

	public String getCalle1() {
		return calle1;
	}

	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}

	public String getCalle2() {
		return calle2;
	}

	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	
}
