package uy.com.jep.enumerator;

public enum TipoCuenta {
	INGRESO(1, "Ingreso Ganancias"),
	VENTA(2,"Ventas"),
	GASTOS(3, "Gastos Perdidas"),
	DEUDAS(4, "Deudas Prestamos"),
	PATRIMONIO(5,"Patrimonio"),
	EGRESO(6,"Egreso");
	
	private int codigo;
	private String descripcion;
	
	TipoCuenta(int codigo, String descripcion){
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
