package org.app.runner;

import java.util.Arrays;
import java.util.List;

import org.app.document.Employee;
import org.app.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	@Override
	public void run(String... args) throws Exception {
		
		repo.deleteAll();
		//1.insert one row
		Employee e=repo.save(new Employee(10,"A",2.2));
		System.out.println(e.getId());
		//2.bulk insert
		List<Employee> emps=repo.saveAll(Arrays.asList(
				new Employee(11,"B", 3.3),
				new Employee(12,"C",4.5),
				new Employee(13,"D",5.5 )
				)
		);
		for(Employee ee:emps) {
			System.out.println(ee.getId());
		}

		System.out.println("============******=====================");
	}

}
