package uy.com.jep.enumerator;

public enum ListaPreciosTipoModificacion {
	
	MANUAL(1, "Manual"), PORCENTAJE(2, "Porcentaje");
	private int id;
	private String descripcion;
	
	
	ListaPreciosTipoModificacion(int id, String descripcion){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
