package uy.com.jep.enumerator;

public enum TipoVivienda
{
	CASA(1,"Casa"), 
	APARTAMENTO(2, "Apartamento");
	
	private int codigo;
	private String descripcion;
	
	TipoVivienda(int codigo, String descripcion){
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
