package uy.com.jep.mybatis.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;

import uy.com.jep.domains.Product;
import uy.com.jep.services.DepartmentService;


public class ProductSQL {
	
	public String insertProduct(final Product product) {
		
		String result =  new SQL() {{
			INSERT_INTO("product");
			if(!product.getName().equals(null) && !product.getName().equals("")) {
				VALUES("name","{name}");
			}
			if(!product.getImageUrl().equals(null) && !product.getImageUrl().equals("")) {
				VALUES("image_url","{imageUrl}");
			}
			
			VALUES("impuesto","{impuesto}");
			
			if(product.getDepartment() !=null) {
				VALUES("department_id","{department.id}");
			}
		}}.toString();
		
		return result;
	}
	
	public String updateProduct(final Product product) {
		
		return new SQL() {{
			UPDATE("product");
			if(!product.getImageUrl().equals(null) && !product.getImageUrl().equals("")) {
				SET("image_url","{imageUrl}");
			}
			if(!product.getName().equals(null) && !product.getName().equals("")) {
				SET("name","{name}");
			}
			
			if(product.getDepartment()!=null) {
				SET("department_id","{department.id}");
			}
			
			if(product.getImpuesto()!=null) {
				SET("impuesto_impuesto_id","{impuesto.impuestoId}");
			}
			
		}}.toString();
		
	}
	
	public String deleteProduct(final int id) {
		return new SQL() {{
			DELETE_FROM("product");
			WHERE("id = " + id);
		}}.toString();
		
	}
	
	
	public String listAllProducts() {
		String sql = new SQL() {{
			SELECT("p.id, p.image_url, p.name");
			SELECT("d.id, d.name");
			SELECT("i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_tipo, i.impuesto_valor");
			FROM("product p");
			FROM("department d");
			FROM("impuesto i");
			WHERE("p.impuesto_impuesto_id = i.impuesto_id");
			WHERE("p.department_id = d.id");
			
		}}.toString();
		
		return sql;
	}
	
	public String listProductById(Map<String, Object>map) {
		String id = map.get("department_id").toString();
		return new SQL() {{
			SELECT("p.id, p.image_url, p.name");
			SELECT("d.id, d.name");
			SELECT("i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_tipo, i.impuesto_valor");
			FROM("product p");
			FROM("department d");
			FROM("impuesto i");
			WHERE("p.impuesto_impuesto_id = i.impuesto_id");
			WHERE("p.department_id = d.id");
			WHERE("p.id = "+id);
		}}.toString();
	}
	
	public String listProductByDepartmentId(Map<String, Object>map) {
		String id = map.get("department_id").toString();
		return new SQL() {{
			SELECT("p.id, p.image_url, p.name");
			SELECT("d.id, d.name");
			SELECT("i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_tipo, i.impuesto_valor");
			FROM("product p");
			FROM("department d");
			FROM("impuesto i");
			WHERE("p.impuesto_impuesto_id = i.impuesto_id");
			WHERE("p.department_id = d.id");
			WHERE("d.id = "+id);
		}}.toString();
	}
}
