package uy.com.jep.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

public class ListaPreciosSQL {
	
	public String findAllListaPrecios() {
		
		return new SQL() {{
			SELECT("");
		}}.toString();
	}

}
