package com.example.demo.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
/*List<Employee> list;*/

public EmployeeServiceImpl() {
	/* list = new ArrayList<>();
	list.add(new Employee(122,"Anjali","Kolkata",12));
	list.add(new Employee(123,"Ankita","Mumbai",11));*/
}

	@Override
	public List<Employee> getEmployees() {
		
		return employeeDao.findAll();
	}
	@Override
	public Employee getEmployee(long employeeId) {
		
		/*Employee e=null;
		for(Employee employee:list)
		{
			if(employee.getEmp_id() == employeeId) {
				e = employee;
				break;
			}
		}*/
		return employeeDao.findById(employeeId).orElse(null);
		//getOne(employeeId);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		/*list.add(employee);*/
		employeeDao.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		/*list.forEach(e -> {
			if(e.getEmp_id()==employee.getEmp_id()) {
				e.setName(employee.getName());
				e.setCity(employee.getCity());
				e.setDept_id(employee.getDept_id());
			}
		}); */
		employeeDao.save(employee);
		return employee;
	}

	@Override
	public void deleteEmployee(long parseLong) {
		// TODO Auto-generated method stub
		/*list=this.list.stream().filter(e->e.getEmp_id()!=parseLong).collect(Collectors.toList());*/
		Employee entity = employeeDao.getOne(parseLong);
		employeeDao.delete(entity);
				}

}


