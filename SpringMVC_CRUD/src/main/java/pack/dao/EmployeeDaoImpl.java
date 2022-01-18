package pack.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pack.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoInf {

	@Autowired	
	  DataSource dataSource;
	
	@Override
	public int insert(Employee e) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		int i=insert.update("insert into register(name,email,gender,country)  values(?,?,?,?)",e.getName(),e.getEmail(),e.getGender(),e.getCountry());
		return i;
	}

	@Override
	public List<Employee> viewAll() {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		String sql = "SELECT * from register";
		
		List<Employee> emp  = insert.query(sql,new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}

	@Override
	public Employee getEmpById(int id) {
		JdbcTemplate obj = new JdbcTemplate(dataSource);
	    String sql="select * from register where id=?";    
	    Employee emp= obj.queryForObject(sql,new BeanPropertyRowMapper<Employee>(Employee.class), new Object[]{id});  
	    return emp;
	}

	@Override
	public int modify(Employee e) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		int i=insert.update("update register set name='"+e.getName()+"',email='"+e.getEmail()+"' where id="+e.getId());
		return i;
	}

	@Override
	public int delete(int id) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		String sql="delete from register where id=?";
		int i=insert.update(sql,id);
		return i;
	}

}
