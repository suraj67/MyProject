package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dao.EmployeeDaoInf;
import pack.model.Employee;

@Controller
public class EmployeeController {
	 @Autowired 
	EmployeeDaoInf employeeDao;
		   	
	 @RequestMapping("/")
		public String meth1() {
			return "index";
		}
	 
	 
	@RequestMapping("/addUserForm")  
 public String add(Model m)  
 {  
     m.addAttribute("emp", new  Employee());  
     return "userForm";  
 }
	
	
	  @RequestMapping(value = "/addEmployee", method = RequestMethod.POST) 
	  public String addStudent(Employee employee) {
		 int res= employeeDao.insert(employee);
		 if (res>=1)
		  return "redirect:/viewForm";
		 else
			 return "adduser-error";
	   
	  }
	 
	  
	  
	
	  @RequestMapping("/viewForm")    
	    public String viewemp(Model m){    
	        List<Employee> list=employeeDao.viewAll();  
	        m.addAttribute("list",list);  
	        return "view";    
	    }  
	  
	  
		
		@RequestMapping("/editEmp")  
	    public String edit( @RequestParam("id") int ide, Model m){    
			 
		Employee emp=employeeDao.getEmpById(ide);
		m.addAttribute("editEmpForm",emp);
			 
			System.out.println("id "+ide);
			 
	        return "editAction";    
	    } 
		
		
		@RequestMapping("/editEmployee")
		public String modify(Employee employee)
		{
			int res=employeeDao.modify(employee);
			if (res>=1)
				  return "redirect:/viewForm";
				 else
					 return "adduser-error";
			  			 
		}
		
		@RequestMapping("/deleteEmp")
		public String delete( @RequestParam("id") int ide)
		{
			int res=employeeDao.delete(ide);
			if (res>=1)
				  return "redirect:/viewForm";
				 else
					 return "adduser-error";
			  			 
		}
		
		 
}
