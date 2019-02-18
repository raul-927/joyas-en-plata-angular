package uy.com.jep.services;

import java.util.List;

import uy.com.jep.domains.Cuentas;

public interface CuentasService {
	void insertCuenta(final Cuentas cuenta);
	void updateCuenta(final Cuentas cuenta);
	void deleteCuenta(final int cuentaId);
	
	Cuentas getCuentaByCuentaId(final int cuentaId);
	List<Cuentas>listAllCuentas();
	List<Cuentas>listCuentasByGrupoCuentaId(final int grupoCuentaId);
}
