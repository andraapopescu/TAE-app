package ebusiness.tae.project.domain.dao;

import ebusiness.tae.project.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository <Employee, Long> {
    List<Employee> findByLastName(String name);
    List<Employee> findByEmail(String email);
}
