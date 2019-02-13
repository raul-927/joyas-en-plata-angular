package uy.com.jep.enumerator;

public enum ListaPreciosTipoModificacion {
	
	MANUAL(1, "Manual"), PORCENTAJE(2, "Porcentaje");
	private int codigo;
	private String descripcion;
	
	
	ListaPreciosTipoModificacion(int codigo, String descripcion){
		this.codigo = codigo;
	}
	
	public int getCodigo(){
		return this.codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
