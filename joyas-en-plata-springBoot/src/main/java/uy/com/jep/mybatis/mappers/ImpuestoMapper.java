package uy.com.jep.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import uy.com.jep.domains.Impuesto;
import uy.com.jep.mybatis.sql.ImpuestosSQL;

public interface ImpuestoMapper {
	
	@InsertProvider(type = ImpuestosSQL.class, method ="insertImpuesto")
	void insertImpuesto(Impuesto impuesto);
	
	@UpdateProvider(type = ImpuestosSQL.class, method ="updateImpuesto")
	void updateImpuesto(Impuesto impuesto);
	
	@DeleteProvider(type =ImpuestosSQL.class, method ="deleteImpuesto")
	void deleteImpuesto(final int impuestoId);
	
	@SelectProvider(type = ImpuestosSQL.class, method ="getImpuestoById")
	@ResultMap("uy.com.jep.mybatis.mappers.ImpuestoMapper.ImpuestoResult")
	Impuesto getImpuestoById(final int id);
	
	@SelectProvider(type = ImpuestosSQL.class, method ="listAllImpuestos")
	@ResultMap("uy.com.jep.mybatis.mappers.ImpuestoMapper.ImpuestoResult")
	List<Impuesto> listAllImpuestos();
	
	@SelectProvider(type = ImpuestosSQL.class, method ="listImpuestoByCuentaId")
	@ResultMap("uy.com.jep.mybatis.mappers.ImpuestoMapper.ImpuestoResult")
	List<Impuesto> listImpuestoByCuentaId(final int id);

}
