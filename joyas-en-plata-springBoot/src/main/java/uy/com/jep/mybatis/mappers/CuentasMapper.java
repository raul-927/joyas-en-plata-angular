package uy.com.jep.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import uy.com.jep.domains.Cuentas;
import uy.com.jep.mybatis.sql.CuentasSQL;

public interface CuentasMapper {
	@InsertProvider(type= CuentasSQL.class, method ="insertCuenta")
	void insertCuenta(final Cuentas cuenta);
	
	@UpdateProvider(type= CuentasSQL.class, method ="updateCuenta")
	void updateCuenta(final Cuentas cuenta);
	
	@DeleteProvider(type= CuentasSQL.class, method ="deleteCuenta")
	void deleteCuenta(final int cuentaId);
	
	@SelectProvider(type= CuentasSQL.class, method ="getCuentaByCuentaId")
	@ResultMap("uy.com.jep.mybatis.mappers.CuentasMapper.CuentasResult")
	Cuentas getCuentaByCuentaId(final int cuentaId);
	
	@SelectProvider(type= CuentasSQL.class, method ="listAllCuentas")
	@ResultMap("uy.com.jep.mybatis.mappers.CuentasMapper.CuentasResult")
	List<Cuentas>listAllCuentas();
	
	@SelectProvider(type= CuentasSQL.class, method ="listCuentasByGrupoCuentaId")
	@ResultMap("uy.com.jep.mybatis.mappers.CuentasMapper.CuentasResult")
	List<Cuentas>listCuentasByGrupoCuentaId(final int grupoCuentaId);

}
