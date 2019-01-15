package uy.com.jep.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import uy.com.jep.domains.Cliente;
import uy.com.jep.domains.SearchClientes;

public class ClientesSQL {
	
	public String findAllClientes() {
		return new SQL(
			
		) {{
			SELECT("id, nombre, apellido, cedula, ocupacion");
			FROM("cliente");
		}}.toString();
		
	}
	
	public String findClientes(SearchClientes searchClientes) {
		String sql = new SQL() {{
			SELECT("id, nombre, apellido, cedula, ocupacion");
			FROM("cliente");
			if(searchClientes.getCedula()>0) {
				WHERE("cedula ="+searchClientes.getCedula());
			}
			else {
				if(searchClientes.getNombre() !=null && searchClientes.getNombre() !="") {
					WHERE("nombre ="+searchClientes.getNombre());
				}
				
				if(searchClientes.getApellido() !=null && searchClientes.getApellido() !="") {
					WHERE("apellido ="+searchClientes.getApellido());
				}
			}
		}}.toString();
		
		return sql;
	}
	
	public String findClienteById(int id) {
		return new SQL() {{
			SELECT("id, nombre, apellido, cedula, ocupacion");
			FROM("cliente");
			WHERE("id ="+id);
		}}.toString();
	}
	
	public String insertCliente(Cliente cliente) {
		return new SQL() {{
			INSERT_INTO("cliente");
			VALUES("nombre", cliente.getNombre());
			VALUES("apellido", cliente.getApellido());
			VALUES("cedula", String.valueOf(cliente.getCedula()));
			if(cliente.getOcupacion()!= null && cliente.getOcupacion() !="") {
				VALUES("ocupacion",cliente.getOcupacion());
			}
		}}.toString();
	}
	
	public String findClientesByNom(String nombre) {
		return new SQL(){{
			SELECT("id, nombre, apellido, cedula, ocupacion");
			FROM("cliente");
			WHERE("nombre ="+nombre);
		}}.toString(); 
	}
	
	public String findClientesByApellido(String apellido) {
		return new SQL(){{
			SELECT("id, nombre, apellido, cedula, ocupacion");
			FROM("cliente");
			WHERE("apellido ="+apellido);
		}}.toString(); 
	}
	
	public String findClienteByCedula(int cedula) {
		return new SQL(){{
			SELECT("id, nombre, apellido, cedula, ocupacion");
			FROM("cliente");
			WHERE("cedula ="+cedula);
		}}.toString(); 
	}
	
	public String updateCliente (Cliente cliente) {
		return new SQL() {{
			UPDATE("clente");
			if(cliente.getNombre() !=null && cliente.getNombre() !="") {
				SET("nombre",cliente.getNombre());
			}
			
			if(cliente.getApellido()!=null && cliente.getApellido() !="") {
				SET("apellido", cliente.getApellido());
			}
			
			if(cliente.getCedula() >0) {
				SET("cedula",String.valueOf(cliente.getCedula()));
			}
			
			if(cliente.getOcupacion() !=null && cliente.getOcupacion()!="") {
				SET("ocupacion",cliente.getOcupacion());
			}
			
			WHERE("cedula = "+cliente.getCedula());
//			sociedad_medica =#{sociedadMedica}
//			emergencia_movil =#{emergenciaMovil}
//			
//			WHERE 	 cedula = #{cedula}"
			
			
			
		}}.toString();
	}
	
	
	
}
