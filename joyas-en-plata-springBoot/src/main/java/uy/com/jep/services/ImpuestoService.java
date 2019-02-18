package uy.com.jep.services;

import java.util.List;

import uy.com.jep.domains.Impuesto;

public interface ImpuestoService {
	void insertImpuesto(Impuesto impuesto);
	void updateImpuesto(Impuesto impuesto);
	void deleteImpuesto(final int impuestoId);
	
	Impuesto getImpuestoById(final int id);
	List<Impuesto> listAllImpuestos();
	List<Impuesto> listImpuestoByCuentaId(final int id);
}
