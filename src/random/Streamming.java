package random;

import random.dao.EmployeeDataBase;
import random.pojo.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Streamming {

	public static void sortMap(){
		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("one", 1);
		map.put("four", 4);
		map.put("two", 2);
		
		System.out.println("Primitive/wrapper datatype ops...");
		map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(m->System.out.println("by key:"+m));

		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(m->System.out.println("by value:"+m));
		
		System.out.println("Custom datatype ops...");
		Map<Employee, Integer> customMap = new HashMap<>();
		customMap.put(new Employee(17, "Roshan", "IT",600000), 4);
		customMap.put(new Employee(176, "Moshan", "IT",1200000), 44);
		customMap.put(new Employee(388, "Bikash", "CIVIL",900000), 2);
		customMap.put(new Employee(1, "Bimal", "DEFENCE",500000), 5);
		customMap.put(new Employee(624, "Sourav", "CORE",400000), 1);
		customMap.put(new Employee(624, "Gourav", "CORE",4400000), 1);
		customMap.put(new Employee(174, "Prakash", "SOCIAL",1200000), 3);
		
		customMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println);
	}
	public static void main(String[] args) {
		List<Employee> employees = EmployeeDataBase.getEmployees();
		
		//Collections.sort(employees, (o1,o2)-> (int)(o1.getSalary()-o2.getSalary()));
		
		System.out.println("Emp list: "+ employees);

		System.out.println(employees.stream().collect(groupingBy(Employee::getDept,mapping(Employee::getName,toList()))));
		employees.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed().thenComparing(Employee::getId).thenComparing(Employee::getDept)).forEach(System.out::println);


		employees.stream().sorted(Comparator.comparing(Employee::getDept)).forEach(e->System.out.println(e));

		Long aLong = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).map(e -> e.getSalary()).collect(toList()).get(0);
		System.out.println("Emp salary min="+aLong);

		Long bLong = employees.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).map(e -> e.getSalary()).collect(toList()).get(0);
		System.out.println("Emp salary max="+bLong);

//		System.out.println("Sorted: "+ employees);
		
		sortMap();
		Comparator<Employee> comp=Comparator.comparing(Employee::getSalary);
		/*
		 * Comparator<Employee> comp=Comparator.comparing(Employee::getSalary);
		 * 
		 * employees.stream() .collect(Collectors.groupingBy(Employee::getDept),
		 * Collectors.reducing(BinaryOperator.maxBy(comp)));
		 */
		
		Employee emp=  employees.stream().collect(Collectors.maxBy(comp)).get();
		
		System.out.println("max sal::"+emp);
		employees.stream().collect(groupingBy(Employee::getDept));
		
		System.out.println("max sal::"+emp);

		//3rd highest salary
		long salary = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(toList()).get(2).getSalary();
		System.out.println("3rd highest sal= "+ salary);

		List<Employee> employees1 = employees.stream().filter(e -> e.getSalary() >600000).collect(toList());
		System.out.println("sal>9L"+employees1);

		String[] alpha= {"Apple","Ball","Cat","Dog"};
		Map<String, String> aFor = Stream.of(alpha).collect(toMap(s -> s.toUpperCase().substring(0, 1), Function.identity()));
		System.out.println(aFor);
	}
	
}
