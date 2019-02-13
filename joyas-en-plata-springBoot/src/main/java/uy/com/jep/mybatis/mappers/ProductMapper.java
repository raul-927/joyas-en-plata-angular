package uy.com.jep.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import uy.com.jep.domains.Product;
import uy.com.jep.mybatis.sql.ProductSQL;

public interface ProductMapper {
	
	
	@InsertProvider(type= ProductSQL.class, method ="insertProduct")
	void insertProduct(Product product);
	
	@UpdateProvider(type = ProductSQL.class, method ="updateProduct")
	void updateProduct(Product product);
	
	@DeleteProvider(type = ProductSQL.class, method ="deleteProduct")
	void deleteProduct(int id);
	
	
	@SelectProvider(type =ProductSQL.class, method="listAllProducts")
	@ResultMap("uy.com.jep.mybatis.mappers.ProductMapper.ProductResult")
	List<Product> listAllProducts();
	
	@SelectProvider(type =ProductSQL.class, method="listProductById")
	@ResultMap("uy.com.jep.mybatis.mappers.ProductMapper.ProductResult")
	Product listProductById(@Param("id") int  id);
	
	
	@SelectProvider(type =ProductSQL.class, method="listProductByDepartmentId")
	@ResultMap("uy.com.jep.mybatis.mappers.ProductMapper.ProductResult")
	List<Product> listProductByDepartmentId(@Param("department_id") int department_id);
	
	
}
