package uy.com.jep.enumerator;

public enum ListaPreciosOptions {
	NUEVA_LISTA_PRECIOS(1, "Nueva lista de precios"), 
	COPIAR_Y_MODIFICAR_LISTA_PRECIOS(2, "Copiar y modificar lista de precios"),
	INSERTAR_TRATAMIENTO_EN_LISTA_ACTUAL(3, "Insertar tratamiento en lista actual");
	private int codigo;
	private String descripcion;
	
	ListaPreciosOptions(int codigo, String descripcion){
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
