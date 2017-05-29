package ebusiness.tae.project.controller;

import ebusiness.tae.project.domain.Employee;
import ebusiness.tae.project.domain.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/allEmployees")
public class RestEmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public RestEmployeeController(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> result = (ArrayList<Employee>) employeeRepository.findAll();

        if (result.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Employee>>(result, HttpStatus.OK);
    }
}
