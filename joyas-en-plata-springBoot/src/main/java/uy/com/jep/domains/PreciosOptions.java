package uy.com.jep.domains;

import java.io.Serializable;

public class PreciosOptions implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String opcion;

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
}
