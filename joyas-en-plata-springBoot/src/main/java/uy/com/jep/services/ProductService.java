package uy.com.jep.services;

import java.util.List;

import uy.com.jep.domains.Product;

public interface ProductService {
	
	void insertProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int id);
	
	List<Product> listAllProducts();
	Product listProductById(int  id);
	List<Product> listProductByDepartmentId(int department_id);
}
