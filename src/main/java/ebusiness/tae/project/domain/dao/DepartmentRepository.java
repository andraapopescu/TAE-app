package ebusiness.tae.project.domain.dao;

import ebusiness.tae.project.domain.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    List<Department> findByName(String name);
}
