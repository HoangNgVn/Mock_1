package com.example.mock_1.api_layer;

import com.example.mock_1.entity.Employee;
import com.example.mock_1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "employee")
public class EmployeeAPI {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "{employeeId}")
    public Optional<Employee> getEmloyeeById(@PathVariable("employeeId") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public String addEmployee(@RequestBody @Valid Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping(path = "{employeeId}")
    public String updateEmployee(@PathVariable("employeeId") int id, @RequestBody @Valid Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping(path = "{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int id) {
        return employeeService.deleteEmployee(id);
    }

}
