package uy.com.jep.mybatis.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import uy.com.jep.domains.Department;

public class DepartmentSQL {
	
	public String insertDepartment(Department department) {
		return new SQL() {{
			INSERT_INTO("department");
			VALUES("id", "'".concat(String.valueOf(department.getId())).concat("'"));
			VALUES("name", "'".concat(department.getName()).concat("'"));
		}}.toString();
	}
	
	public String updateDepartment(Department department) {
		return new SQL() {{
			
		}}.toString();
	}
	public String deleteDepartment(int id) {
		return new SQL() {{
			DELETE_FROM("department");
			WHERE("id = " +"'".concat(String.valueOf(id)).concat("'"));
		}}.toString();
	}
	
	public String listAllDepartment() {
		return new SQL() {{
			SELECT("id, name");
			FROM("department");
		}}.toString();
	}
	
	public String listDepartment(Map<String,Object>map) {
		int id = Integer.parseInt(map.get("id").toString());
		return new SQL() {{
			SELECT("id, name");
			FROM("department");
			WHERE("id = " +id);
		}}.toString();
	}
	
	
	
	

}
