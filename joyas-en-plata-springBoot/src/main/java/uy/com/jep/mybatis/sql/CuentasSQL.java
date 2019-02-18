package uy.com.jep.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import uy.com.jep.domains.Cuentas;

public class CuentasSQL {

	public String insertCuenta(final Cuentas cuenta) {
		
		return new SQL() {{
			INSERT_INTO("cuentas");
			if(!cuenta.getCuentaDesc().equals(null) && !cuenta.getCuentaDesc().equals("")) {
				VALUES("cuenta_desc", "'".concat(cuenta.getCuentaDesc()).concat("'"));
			}
			if(!cuenta.getCuentaFecha().equals(null) && !cuenta.getCuentaFecha().equals("")) {
				VALUES("cuenta_fecha","'".concat(cuenta.getCuentaFecha()).concat("'"));
			}
			if(!cuenta.getCuentaHora().equals(null) && !cuenta.getCuentaHora().equals("")) {
				VALUES("cuenta_hora","'".concat(cuenta.getCuentaHora()).concat("'"));
			}
			if(!cuenta.getCuentaTipo().equals(null) && !cuenta.getCuentaTipo().equals("")) {
				VALUES("cuenta_tipo","'".concat(cuenta.getCuentaTipo()).concat("'"));
			}
			if(!cuenta.getCuentaUsuario().equals(null) && !cuenta.getCuentaUsuario().equals("")) {
				VALUES("cuenta_usuario","'".concat(cuenta.getCuentaUsuario()).concat("'"));
			}
			if(cuenta.getGrupoCuentas()!=null) {
				String grupoCuentaId = String.valueOf(cuenta.getGrupoCuentas().getGrupoCuentaId());
				VALUES("grupo_cuentas_grupo_cuenta_id", "'".concat(grupoCuentaId).concat("'"));
			}
		}}.toString();
	}
	
	
	public String updateCuenta(final Cuentas cuenta) {
		
		return new SQL() {{
			UPDATE("cuentas");
			if(!cuenta.getCuentaDesc().equals(null) && !cuenta.getCuentaDesc().equals("")) {
				SET("cuenta_desc = '".concat(cuenta.getCuentaDesc()).concat("'"));
			}
			if(!cuenta.getCuentaFecha().equals(null) && !cuenta.getCuentaFecha().equals("")) {
				SET("cuenta_fecha= '".concat(cuenta.getCuentaFecha()).concat("'"));
			}
			if(!cuenta.getCuentaHora().equals(null) && !cuenta.getCuentaHora().equals("")) {
				SET("cuenta_hora= '".concat(cuenta.getCuentaHora()).concat("'"));
			}
			if(!cuenta.getCuentaTipo().equals(null) && !cuenta.getCuentaTipo().equals("")) {
				SET("cuenta_tipo= '".concat(cuenta.getCuentaTipo()).concat("'"));
			}
			if(!cuenta.getCuentaUsuario().equals(null) && !cuenta.getCuentaUsuario().equals("")) {
				SET("cuenta_usuario= '".concat(cuenta.getCuentaUsuario()).concat("'"));
			}
			if(cuenta.getGrupoCuentas()!=null) {
				String grupoCuentaId = String.valueOf(cuenta.getGrupoCuentas().getGrupoCuentaId());
				SET("grupo_cuentas_grupo_cuenta_id= '".concat(grupoCuentaId).concat("'"));
			}
			WHERE("cuenta_id = "+cuenta.getCuentaId());
			
		}}.toString();
	}
	
	public String deleteCuenta(final int cuentaId) {
		
		return new SQL() {{
			DELETE_FROM("cuentas");
			WHERE("cuenta_id ="+cuentaId);
		}}.toString();
	}
	
	public String getCuentaByCuentaId(final int cuentaId) {
		
		return new SQL() {{
			SELECT("c.cuenta_id, c.cuenta_desc, c.cuenta_fecha, c.cuenta_hora, c.cuenta_tipo, c.cuenta_usuario, c.grupo_cuentas_grupo_cuenta_id");
			SELECT("g.grupo_cuenta_id, g.grupo_cuenta_desc, g.tipo_cuenta");
			FROM("cuentas c");
			FROM("grupo_cuentas g");
			WHERE("c.cuenta_id = "+cuentaId);
			WHERE("c.grupo_cuentas_grupo_cuenta_id = g.grupo_cuenta_id");
			}}.toString();
	}
	
	public String listAllCuentas() {
		
		return new SQL() {{
			SELECT("c.cuenta_id, c.cuenta_desc, c.cuenta_fecha, c.cuenta_hora, c.cuenta_tipo, c.cuenta_usuario, c.grupo_cuentas_grupo_cuenta_id");
			SELECT("g.grupo_cuenta_id, g.grupo_cuenta_desc, g.tipo_cuenta");
			FROM("cuentas c");
			FROM("grupo_cuentas g");
			WHERE("c.grupo_cuentas_grupo_cuenta_id = g.grupo_cuenta_id");
			}}.toString();
	}
	
	public String listCuentasByGrupoCuentaId(final int grupoCuentaId) {
		
		return new SQL() {{
			SELECT("c.cuenta_id, c.cuenta_desc, c.cuenta_fecha, c.cuenta_hora, c.cuenta_tipo, c.cuenta_usuario, c.grupo_cuentas_grupo_cuenta_id");
			SELECT("g.grupo_cuenta_id, g.grupo_cuenta_desc, g.tipo_cuenta");
			FROM("cuentas c");
			FROM("grupo_cuentas g");
			WHERE("c.grupo_cuentas_grupo_cuenta_id = g.grupo_cuenta_id");
			WHERE("g.grupo_cuenta_id = "+grupoCuentaId);
			}}.toString();
	}
	
}
