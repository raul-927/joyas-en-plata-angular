package uy.com.jep.enumerator;

public enum TipoDocumento {
	DNI(1, "Documento Nacional de Identificación"),
	CED(2, "Cédula de Identidad"),
	CEE(3, "Carné de Extrangería"),
	PAS(4, "Pasaporte");
	
	private int idDoc;
	private String descripcion;
	
	TipoDocumento(int idDoc, String descripcion){
		this.idDoc = idDoc;
		this.descripcion = descripcion;
	}
	
	public int getIdDoc(){
		return this.idDoc;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
