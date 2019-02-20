package uy.com.jep.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import uy.com.jep.domains.GrupoCuentas;
import uy.com.jep.mybatis.sql.GrupoCuentasSQL;

public interface GrupoCuentasMapper {

	@InsertProvider(type = GrupoCuentasSQL.class, method ="insertGrupoCuentas")
	void insertGrupoCuentas(GrupoCuentas grupoCuentas);
	
	@UpdateProvider(type = GrupoCuentasSQL.class, method ="updateGrupoCuentas")
	void updateGrupoCuentas(GrupoCuentas grupoCuentas);
	
	@DeleteProvider(type = GrupoCuentasSQL.class, method ="deleteGrupoCuentas")
	void deleteGrupoCuentas(@Param("grupoCuentaId") int grupoCuentaId);
	
	@SelectProvider(type = GrupoCuentasSQL.class, method ="getGrupoCuentaByGrupoCuentaId")
	@ResultMap("uy.com.jep.mybatis.mappers.GrupoCuentasMapper.GrupoCuentasResult")
	GrupoCuentas getGrupoCuentaByGrupoCuentaId(@Param("grupoCuentaId") int grupoCuentaId);
	
	@SelectProvider(type = GrupoCuentasSQL.class, method ="listAllGrupoCuentas")
	@ResultMap("uy.com.jep.mybatis.mappers.GrupoCuentasMapper.GrupoCuentasResult")
	List<GrupoCuentas> listAllGrupoCuentas();
	
}
