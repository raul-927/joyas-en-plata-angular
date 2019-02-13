package uy.com.jep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.com.jep.domains.Department;
import uy.com.jep.mybatis.mappers.DepartmentMapper;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public void insert(Department department) {
		this.departmentMapper.insert(department);

	}

	@Override
	public void update(Department department) {
		this.update(department);

	}

	@Override
	public void delete(int id) {
		this.departmentMapper.delete(id);

	}

	@Override
	public List<Department> listAllDepartments() {
		
		return this.departmentMapper.listAllDepartments();
	}

	@Override
	public Department listDepartmentById(int id) {
	
		return this.departmentMapper.listDepartmentById(id);
	}

}
