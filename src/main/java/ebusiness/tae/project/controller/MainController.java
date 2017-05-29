package ebusiness.tae.project.controller;

import ebusiness.tae.project.domain.Department;
import ebusiness.tae.project.domain.Employee;
import ebusiness.tae.project.domain.Function;
import ebusiness.tae.project.domain.dao.DepartmentRepository;
import ebusiness.tae.project.domain.dao.EmployeeRepository;
import ebusiness.tae.project.domain.dao.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final FunctionRepository functionRepository;

    @Autowired
    public MainController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,
                          FunctionRepository functionRepository) {

        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.functionRepository = functionRepository;
    }

    @GetMapping("/")
    public String getAllEmployees(Model model) {
        List<Employee> employees = (ArrayList<Employee>) employeeRepository.findAll();
        List<Department> departments = (ArrayList<Department>) departmentRepository.findAll();
        List<Function> functions = (ArrayList<Function>) functionRepository.findAll();

        model.addAttribute("employees", employees);
        model.addAttribute("departments", departments);
        model.addAttribute("functions", functions);

        model.addAttribute("department", new Department());
        model.addAttribute("function", new Function());
        model.addAttribute("employee", new Employee());

        return "index";
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public String deleteEmployee(@PathVariable("id") Long id) {

        employeeRepository.delete(id);

        return  "redirect:/";
    }

    @PostMapping("/")
    @Transactional
    public String submitForm(@Valid Employee employee, BindingResult result, Model m) {
        employeeRepository.save(employee);

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String selectEmployee(@PathVariable("id") Long id, Model model, HttpSession session) {
        session.setAttribute("current", employeeRepository.findOne(id));

        return "redirect:/";
    }

    @PostMapping("/{id}/edit")
    @Transactional
    public String saveEmployee(@PathVariable("id") Long id, @ModelAttribute Employee employee, HttpSession session) {

        Employee current = employeeRepository.findOne(id);

        current.setFirstName(employee.getFirstName());
        current.setLastName(employee.getLastName());
        current.setEmail(employee.getEmail());
        current.setDepartment(employee.getDepartment());
        current.setFunction(employee.getFunction());
        current.setSalary(employee.getSalary());

        session.invalidate();

        return "redirect:/";
    }

}