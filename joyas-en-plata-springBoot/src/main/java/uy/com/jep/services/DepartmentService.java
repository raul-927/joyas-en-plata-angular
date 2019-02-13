package uy.com.jep.services;

import java.util.List;

import uy.com.jep.domains.Department;

public interface DepartmentService {
	void insert(Department department);
	void update(Department department);
	void delete(int id);
	
	List<Department> listAllDepartments();
	Department listDepartmentById(int id);
}
