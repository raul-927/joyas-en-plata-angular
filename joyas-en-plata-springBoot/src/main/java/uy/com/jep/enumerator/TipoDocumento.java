package uy.com.jep.enumerator;

public enum TipoDocumento {
	DNI(1, "Documento Nacional de Identificación"),
	CED(2, "Cédula de Identidad"),
	CEE(3, "Carné de Extrangería"),
	PAS(4, "Pasaporte");
	
	private int codigo;
	private String descripcion;
	
	TipoDocumento(int codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public int getCodigo(){
		return this.codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
