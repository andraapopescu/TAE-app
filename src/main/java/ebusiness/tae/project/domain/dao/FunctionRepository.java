package ebusiness.tae.project.domain.dao;

import ebusiness.tae.project.domain.Employee;
import ebusiness.tae.project.domain.Function;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FunctionRepository extends CrudRepository<Function, Long> {

}
