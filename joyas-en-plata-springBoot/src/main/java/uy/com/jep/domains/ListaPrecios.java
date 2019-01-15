package uy.com.jep.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lista_precios")
public class ListaPrecios implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int listPrecId;
	private int listPrecProductId;
	private int	listPrecMonto;
	
	public int getListPrecId() {
		return listPrecId;
	}
	public void setListPrecId(int listPrecId) {
		this.listPrecId = listPrecId;
	}

	public int getListPrecProductId() {
		return listPrecProductId;
	}
	public void setListPrecProductId(int listPrecProductId) {
		this.listPrecProductId = listPrecProductId;
	}
	public int getListPrecMonto() {
		return listPrecMonto;
	}
	public void setListPrecMonto(int listPrecMonto) {
		this.listPrecMonto = listPrecMonto;
	}
	
	
}


