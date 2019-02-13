package uy.com.jep.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import uy.com.jep.mybatis.sql.DepartmentSQL;
import uy.com.jep.domains.Department;

public interface DepartmentMapper {
	
	@InsertProvider(type=DepartmentSQL.class, method ="insertDepartment")
	void insert(Department department);
	
	@UpdateProvider(type=DepartmentSQL.class, method ="updateDepartment")
	void update(Department department);
	
	
	@DeleteProvider(type = DepartmentSQL.class, method ="deleteDepartment")
	void delete(int id);
	
	@SelectProvider(type= DepartmentSQL.class, method="listAllDepartment")
	@ResultMap("uy.com.jep.mybatis.mappers.DepartmentMapper.DepartmentResult")
	List<Department> listAllDepartments();
	
	@SelectProvider(type= DepartmentSQL.class, method="listDepartment")
	@ResultMap("uy.com.jep.mybatis.mappers.DepartmentMapper.DepartmentResult")
	Department listDepartmentById(@Param("id")int id);
	
	

}
