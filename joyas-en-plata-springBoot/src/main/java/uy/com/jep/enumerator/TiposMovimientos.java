package uy.com.jep.enumerator;

public enum TiposMovimientos {
	DEBE(1, "Debe"),
	HABER(2, "Haber");
	
	private int codigo;
	private String descripcion;
	
	TiposMovimientos(int codigo, String descripcion){
		this.codigo = codigo;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
}
