package uy.com.jep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.com.jep.domains.Cuentas;
import uy.com.jep.mybatis.mappers.CuentasMapper;

@Service("cuentasService")
public class CuentasServiceImpl implements CuentasService {

	@Autowired
	private CuentasMapper cuentasMapper;
	
	@Override
	public void insertCuenta(Cuentas cuenta) {
		this.cuentasMapper.insertCuenta(cuenta);

	}

	@Override
	public void updateCuenta(Cuentas cuenta) {
		this.cuentasMapper.updateCuenta(cuenta);

	}

	@Override
	public void deleteCuenta(int cuentaId) {
		this.cuentasMapper.deleteCuenta(cuentaId);

	}

	@Override
	public Cuentas getCuentaByCuentaId(int cuentaId) {
		
		return this.cuentasMapper.getCuentaByCuentaId(cuentaId);
	}

	@Override
	public List<Cuentas> listAllCuentas() {
		
		return this.cuentasMapper.listAllCuentas();
	}

	@Override
	public List<Cuentas> listCuentasByGrupoCuentaId(int grupoCuentaId) {
		
		return this.cuentasMapper.listCuentasByGrupoCuentaId(grupoCuentaId);
	}

}
