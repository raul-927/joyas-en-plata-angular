package uy.com.jep.enumerator;

public enum CuentaTipo{
	VENTA(1,"VENTA"), 
	IMPOSTIVO(2, "IMPOSTIVO"), 
	TRATAMIENTO(3, "TRATAMIENTO"),
	RETIRO(4, "RETIRO"),
	GASTOS(5, "GASTOS");
	
	private int codigo;
	private String descripcion;
	
	
	CuentaTipo(int codigo, String descripcion){
		this.descripcion = descripcion;
		this.codigo = codigo;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
}
