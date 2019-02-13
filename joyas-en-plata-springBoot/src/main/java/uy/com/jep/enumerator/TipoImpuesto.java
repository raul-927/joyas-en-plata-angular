package uy.com.jep.enumerator;

public enum TipoImpuesto {
	ECONOMICO(1, "Económico"),
	PERSONAS(2, "Personas");
	
	private int codigo;
	private String descripcion;
	
	TipoImpuesto(int codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

}
