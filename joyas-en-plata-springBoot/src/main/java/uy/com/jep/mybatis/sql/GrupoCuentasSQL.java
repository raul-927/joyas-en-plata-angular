package uy.com.jep.mybatis.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import uy.com.jep.domains.GrupoCuentas;

public class GrupoCuentasSQL {

	public String insertGrupoCuentas(GrupoCuentas grupoCuentas) {
		
		return new SQL() {{
			
				INSERT_INTO("grupo_cuentas");
				if(grupoCuentas !=null && !grupoCuentas.getGrupoCuentaDesc().equals(null) && !grupoCuentas.getGrupoCuentaDesc().equals("")) {
					VALUES("grupo_cuenta_desc", "'".concat(grupoCuentas.getGrupoCuentaDesc()).concat("'"));
				}
				if(grupoCuentas !=null && !grupoCuentas.getTipoCuenta().equals(null) && !grupoCuentas.getTipoCuenta().equals("")) {
					VALUES("tipo_cuenta","'".concat(grupoCuentas.getTipoCuenta()).concat("'"));
				}
	
			
		}}.toString();
	}
	
	public String updateGrupoCuentas(GrupoCuentas grupoCuentas) {
		
		return new SQL() {{
				UPDATE("grupo_cuentas");
				if(grupoCuentas !=null && !grupoCuentas.getGrupoCuentaDesc().equals(null) && !grupoCuentas.getGrupoCuentaDesc().equals("")) {
					SET("grupo_cuenta_desc = '".concat(grupoCuentas.getGrupoCuentaDesc()).concat("'"));
				}
				if(grupoCuentas !=null && !grupoCuentas.getTipoCuenta().equals(null) && !grupoCuentas.getTipoCuenta().equals("")) {
					SET("tipo_cuenta = '".concat(grupoCuentas.getTipoCuenta()).concat("'"));
				}
				WHERE("grupo_cuenta_id = "+grupoCuentas.getGrupoCuentaId());
			
			
		}}.toString();
	}

	public String deleteGrupoCuentas(Map<String, Object> map) {
		int  grupoCuentaId = Integer.parseInt(map.get("grupoCuentaId").toString());
		return new SQL() {{
			DELETE_FROM("grupo_cuentas");
			WHERE("grupo_cuenta_id = " + grupoCuentaId);
		}}.toString();
	}
	
	public String getGrupoCuentaByGrupoCuentaId(Map<String, Object> map) {
		int grupoCuentaId = Integer.parseInt(map.get("grupoCuentaId").toString());
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
			ORDER_BY("Grupo_cuenta_id");
		}}.toString();
	}
}
