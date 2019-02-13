package uy.com.jep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.jep.domains.Product;
import uy.com.jep.mybatis.mappers.ProductMapper;


@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Transactional
	@Override
	public void insertProduct(Product product) {
		this.productMapper.insertProduct(product);

	}

	@Transactional
	@Override
	public void updateProduct(Product product) {
		this.productMapper.updateProduct(product);

	}

	@Transactional
	@Override
	public void deleteProduct(int id) {
		this.productMapper.deleteProduct(id);

	}

	@Override
	public List<Product> listAllProducts() {
		
		return this.productMapper.listAllProducts();
	}

	@Override
	public Product listProductById(int id) {
		return this.productMapper.listProductById(id);
	}

	@Override
	public List<Product> listProductByDepartmentId(int department_id) {
		
		return this.productMapper.listProductByDepartmentId(department_id);
	}

}
