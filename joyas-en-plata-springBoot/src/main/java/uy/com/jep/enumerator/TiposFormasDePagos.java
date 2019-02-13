package uy.com.jep.enumerator;

public enum TiposFormasDePagos 
{
	EF(1,"Efectivo"),
	TC(2,"Targeta de Credito"),
	TD(3,"Targeta de Debito"), 
	DP(4,"Deposito Cuenta Bancaria"), 
	CE(5,"Credito Efectivo");
	
	private final int codigo;
	private final String descripcion;
	
	
	TiposFormasDePagos(int codigo, String descripcion)
	{
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
