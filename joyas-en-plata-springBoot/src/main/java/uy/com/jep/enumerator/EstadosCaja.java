package uy.com.jep.enumerator;

public enum EstadosCaja {
	
	OPEN(1,"Abierta"),
	CLOSED(2,"Cerrada");
	
	private int codigo;
	private String descripcion;
	
	EstadosCaja(int codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	
}
