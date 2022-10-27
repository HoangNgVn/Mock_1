package com.example.mock_1.service;

import com.example.mock_1.entity.Employee;
import com.example.mock_1.exception.DuplicateException;
import com.example.mock_1.exception.NotFoundException;
import com.example.mock_1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public String addEmployee(Employee employee) {
        Optional<Employee> employeeByEmail = employeeRepository
                .findEmployeeByEmail(employee.getEmployeeEmail());
        Optional<Employee> employeeByPhoneNumber = employeeRepository
                .findEmployeeByPhoneNumber(employee.getEmployeePhone());

        if (employeeByEmail.isPresent() || employeeByPhoneNumber.isPresent()) {
            throw new DuplicateException("Cant' add, Duplicate email or phone number! Employee exists");
        }
        employeeRepository.save(employee);
        return "Add successfully";

    }

    public String updateEmployee(int id, Employee employee) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (!emp.isPresent()) {
            throw new NotFoundException("Can't update, Employee doesn't exist ");
        }
        employee.setEmployeeId(id);
        employeeRepository.save(employee);
        return "Update successfully";
    }

    public String deleteEmployee(int id) {
        Optional<Employee> employeeToDelete = employeeRepository.findById(id);
        if (!employeeToDelete.isPresent()) {
            throw new NotFoundException("It's not have that Employee");
        }
        employeeRepository.deleteById((Integer) id);
        return "Delete successfully";
    }

}
