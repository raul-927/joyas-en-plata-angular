package uy.com.jep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.jep.domains.Impuesto;
import uy.com.jep.mybatis.mappers.ImpuestoMapper;

@Service("impuestoService")
public class ImpuestoServiceImpl implements ImpuestoService{
	
	@Autowired
	private ImpuestoMapper impuestoMapper;

	@Transactional
	@Override
	public void insertImpuesto(Impuesto impuesto) {
		this.impuestoMapper.insertImpuesto(impuesto);
		
	}
	
	@Transactional
	@Override
	public void updateImpuesto(Impuesto impuesto) {
		this.impuestoMapper.updateImpuesto(impuesto);
		
	}
	
	@Transactional
	@Override
	public void deleteImpuesto(int impuestoId) {
		this.impuestoMapper.deleteImpuesto(impuestoId);
		
	}

	@Override
	public Impuesto getImpuestoById(int id) {
		
		return this.impuestoMapper.getImpuestoById(id);
	}

	@Override
	public List<Impuesto> listAllImpuestos() {
		
		return this.impuestoMapper.listAllImpuestos();
	}

	@Override
	public List<Impuesto> listImpuestoByCuentaId(int id) {
		
		return this.listImpuestoByCuentaId(id);
	}

}
