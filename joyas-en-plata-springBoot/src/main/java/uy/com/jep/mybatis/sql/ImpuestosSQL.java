package uy.com.jep.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import uy.com.jep.domains.Impuesto;

public class ImpuestosSQL {
	
	public String insertImpuesto(Impuesto impuesto) {
		
		return new SQL() {{
			INSERT_INTO("impuesto");
			if(!impuesto.getImpuestoDesc().equals(null) && !impuesto.getImpuestoDesc().equals("")) {
				VALUES("impuestoDesc", "'".concat(impuesto.getImpuestoDesc()).concat("'"));
			}
			
			if(!impuesto.getImpuestoDescAbrv().equals(null) && !impuesto.getImpuestoDescAbrv().equals("")) {
				VALUES("impuestoDescAbrv","'".concat(impuesto.getImpuestoDescAbrv()).concat("'"));
			}
			
			if(!impuesto.getImpuestoValor().equals(null)) {
				VALUES("impuestoValor","'".concat(impuesto.getImpuestoValor().toString()).concat("'"));
			}
			
			if(!impuesto.getImpuestoTipo().equals(null) && !impuesto.getImpuestoTipo().equals("")) {
				VALUES("impuestoTipo","'".concat(impuesto.getImpuestoTipo()).concat("'"));
			}
			
			if(!impuesto.getImpuestoCuenta().equals(null)) {
				String cuentaId = String.valueOf(impuesto.getImpuestoCuenta().getCuentaId());
				VALUES("impuesto_cuenta", "'".concat(cuentaId).concat("'"));
			}
		}}.toString();
	}
	
	
	public String updateImpuesto(Impuesto impuesto) {
		
		return new SQL() {{
			UPDATE("impuesto");
			if(!impuesto.getImpuestoDesc().equals(null) && !impuesto.getImpuestoDesc().equals("")) {
				SET("impuestoDesc", "'".concat(impuesto.getImpuestoDesc()).concat("'"));
			}
			
			if(!impuesto.getImpuestoDescAbrv().equals(null) && !impuesto.getImpuestoDescAbrv().equals("")) {
				SET("impuestoDescAbrv = '".concat(impuesto.getImpuestoDescAbrv()).concat("'"));
			}
			
			if(!impuesto.getImpuestoValor().equals(null)) {
				SET("impuestoValor = '".concat(impuesto.getImpuestoValor().toString()).concat("'"));
			}
			
			if(!impuesto.getImpuestoTipo().equals(null) && !impuesto.getImpuestoTipo().equals("")) {
				SET("impuestoTipo = '".concat(impuesto.getImpuestoTipo()).concat("'"));
			}
			
			if(!impuesto.getImpuestoCuenta().equals(null)) {
				String cuentaId = String.valueOf(impuesto.getImpuestoCuenta().getCuentaId());
				SET("impuesto_cuenta = '".concat(cuentaId).concat("'"));
			}
			WHERE("impuesto_id = "+impuesto.getImpuestoId());
		}}.toString();
	}
	
	public String deleteImpuesto(final int impuestoId) {
		return new SQL() {{
			DELETE_FROM("impuesto");
			WHERE("impuesto_id = "+impuestoId);
		}}.toString();
	}
	
	public String getImpuestoById(final int id) {
		return  new SQL() {{
			SELECT("i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_valor, i.impuesto_tipo, i.impuesto_cuenta");
			SELECT("c.cuenta_id, c.cuenta_desc, c.cuenta_fecha, c.cuenta_hora, c.cuenta_tipo, c.cuenta_usuario, c.grupo_cuentas_grupo_cuenta_id");
			SELECT("g.grupo_cuenta_id, g.grupo_cuenta_desc, g.tipo_cuenta");
			FROM("impuesto i");
			FROM("cuentas c");
			FROM("grupo_cuentas g");
			WHERE("i.impuesto_id = "+id);
			WHERE("i.impuesto_cuenta_cuenta_id = c.cuenta_id");
			WHERE("c.grupo_cuentas_grupo_cuenta_id = g.grupo_cuenta_id");
		}}.toString();
	}
	
	public String listAllImpuestos() {
		return new  SQL() {{
			SELECT("i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_valor, i.impuesto_tipo, i.impuesto_cuenta");
			SELECT("c.cuenta_id, c.cuenta_desc, c.cuenta_fecha, c.cuenta_hora, c.cuenta_tipo, c.cuenta_usuario, c.grupo_cuentas_grupo_cuenta_id");
			SELECT("g.grupo_cuenta_id, g.grupo_cuenta_desc, g.tipo_cuenta");
			FROM("impuesto i");
			FROM("cuentas c");
			FROM("grupo_cuentas g");
			WHERE("i.impuesto_cuenta_cuenta_id = c.cuenta_id");
			WHERE("c.grupo_cuentas_grupo_cuenta_id = g.grupo_cuenta_id");
		}}.toString();
		
	}
	
	public String listImpuestoByCuentaId(final int id) {
		return  new SQL() {{
			SELECT("i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_valor, i.impuesto_tipo, i.impuesto_cuenta");
			SELECT("c.cuenta_id, c.cuenta_desc, c.cuenta_fecha, c.cuenta_hora, c.cuenta_tipo, c.cuenta_usuario, c.grupo_cuentas_grupo_cuenta_id");
			SELECT("g.grupo_cuenta_id, g.grupo_cuenta_desc, g.tipo_cuenta");
			FROM("impuesto i");
			FROM("cuentas c");
			FROM("grupo_cuentas g");
			WHERE("c.cuenta_id = "+id);
			WHERE("i.impuesto_cuenta_cuenta_id = c.cuenta_id");
			WHERE("c.grupo_cuentas_grupo_cuenta_id = g.grupo_cuenta_id");
		}}.toString();
	}

}
