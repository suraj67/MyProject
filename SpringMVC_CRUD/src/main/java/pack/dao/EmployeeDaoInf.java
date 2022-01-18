package pack.dao;

import java.util.List;

import pack.model.Employee;

public interface EmployeeDaoInf {
	int insert(Employee e);
	List<Employee> viewAll();
	Employee getEmpById(int id);
	int modify(Employee e);
	int delete(int id);
}
