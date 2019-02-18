package uy.com.jep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.jep.domains.GrupoCuentas;
import uy.com.jep.mybatis.mappers.GrupoCuentasMapper;

@Service("grupoCuentasService")
public class GrupoCuentasServiceImpl implements GrupoCuentasService {
	
	@Autowired
	private GrupoCuentasMapper grupoCuentasMapper;

	@Transactional
	@Override
	public void insertGrupoCuentas(GrupoCuentas grupoCuentas) {
		this.grupoCuentasMapper.insertGrupoCuentas(grupoCuentas);
	}

	@Transactional
	@Override
	public void updateGrupoCuentas(GrupoCuentas grupoCuentas) {
		this.grupoCuentasMapper.updateGrupoCuentas(grupoCuentas);

	}

	@Transactional
	@Override
	public void deleteGrupoCuentas(int grupoCuentaId) {
		this.grupoCuentasMapper.deleteGrupoCuentas(grupoCuentaId);

	}

	@Override
	public GrupoCuentas getGrupoCuentaByGrupoCuentaId(int grupoCuentaId) {
		
		return this.grupoCuentasMapper.getGrupoCuentaByGrupoCuentaId(grupoCuentaId);
	}

	@Override
	public List<GrupoCuentas> listAllGrupoCuentas() {
		
		return this.grupoCuentasMapper.listAllGrupoCuentas();
	}

}
