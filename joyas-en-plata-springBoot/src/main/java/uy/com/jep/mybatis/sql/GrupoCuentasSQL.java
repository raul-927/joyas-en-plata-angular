package uy.com.jep.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import uy.com.jep.domains.GrupoCuentas;

public class GrupoCuentasSQL {

	public String insertGrupoCuentas(GrupoCuentas grupoCuentas) {
		
		return new SQL() {{
			INSERT_INTO("grupo_cuentas");
			if(!grupoCuentas.getGrupoCuentaDesc().equals(null) && !grupoCuentas.getGrupoCuentaDesc().equals("")) {
				VALUES("grupo_cuenta_desc", "'".concat(grupoCuentas.getGrupoCuentaDesc()).concat("'"));
			}
			if(!grupoCuentas.getTipoCuenta().equals(null) && !grupoCuentas.getTipoCuenta().equals("")) {
				VALUES("tipo_cuenta","'".concat(grupoCuentas.getTipoCuenta()).concat("'"));
			}
		}}.toString();
	}
	
	public String updateGrupoCuentas(GrupoCuentas grupoCuentas) {
		
		return new SQL() {{
			UPDATE("grupo_cuentas");
			if(!grupoCuentas.getGrupoCuentaDesc().equals(null) && !grupoCuentas.getGrupoCuentaDesc().equals("")) {
				SET("grupo_cuenta_desc = '".concat(grupoCuentas.getGrupoCuentaDesc()).concat("'"));
			}
			if(!grupoCuentas.getTipoCuenta().equals(null) && !grupoCuentas.getTipoCuenta().equals("")) {
				SET("tipo_cuenta = '".concat(grupoCuentas.getTipoCuenta()).concat("'"));
			}
			SET();
			WHERE("grupo_cuenta_id = "+grupoCuentas.getGrupoCuentaId());
		}}.toString();
	}

	public String deleteGrupoCuentas(final int grupoCuentaId) {
		
		return new SQL() {{
			DELETE_FROM("grupo_cuentas");
			WHERE("grupo_cuenta_id = "+grupoCuentaId);
		}}.toString();
	}
	
	public String getGrupoCuentaByGrupoCuentaId(final int grupoCuentaId) {
		
		return new SQL() {{
			SELECT("grupo_cuenta_id, grupo_cuenta_desc, tipo_cuenta");
			FROM("grupo_cuentas");
			WHERE("grupo_cuenta_id = "+grupoCuentaId);
		}}.toString();
	}
	
	public String listAllGrupoCuentas() {
		
		return new SQL() {{
			SELECT("grupo_cuenta_id, grupo_cuenta_desc, tipo_cuenta");
			FROM("grupo_cuentas");
		}}.toString();
	}
}
