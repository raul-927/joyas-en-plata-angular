package uy.com.jep.services;

import java.util.List;

import uy.com.jep.domains.GrupoCuentas;

public interface GrupoCuentasService {
	void insertGrupoCuentas(GrupoCuentas grupoCuentas);
	void updateGrupoCuentas(GrupoCuentas grupoCuentas);
	void deleteGrupoCuentas(final int grupoCuentaId);
	
	GrupoCuentas getGrupoCuentaByGrupoCuentaId(final int grupoCuentaId);
	List<GrupoCuentas> listAllGrupoCuentas();
}
