package random.dao;

import random.pojo.Employee;

import java.util.ArrayList;
import java.util.List;
//DAO layer
public class EmployeeDataBase {

	public static List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(176, "Roshan", "IT", 600000));
		list.add(new Employee(388, "Bikash", "CIVIL2", 900000));
		list.add(new Employee(470, "Bimal", "DEFENCE2", 500000));
		list.add(new Employee(624, "Sourav", "IT", 400000));
		list.add(new Employee(176, "Prakash", "SOCIAL", 1200000));
		list.add(new Employee(111, "Prakash", "DEFENCE", 500000));
		list.add(new Employee(213, "Prakash", "DEFENCE3", 500000));
		list.add(new Employee(288, "Prakash", "CIVIL", 900000));
		return list;
	}

}