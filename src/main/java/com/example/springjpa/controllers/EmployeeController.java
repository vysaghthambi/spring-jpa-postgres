package com.example.springjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.model.Employee;
import com.example.springjpa.repository.EmployeeRepository;
import com.example.springjpa.services.EmployeeService;

@RestController
@RequestMapping("employee/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepo;

    @PostMapping("add")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveAllEmployees(employees);
    }

    @GetMapping("all")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("name")
    public List<Employee> getAllEmployeesWithName(@RequestParam String name) {
        return employeeService.findEmployeesByName(name);
    }

    @GetMapping("id")
    public Employee getEmployeeById(@RequestParam int id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("ids")
    public List<Employee> getEmployeesByIds(@RequestBody List<Integer> ids) {
        return employeeService.findAllEmployeesById(ids);
    }

    @GetMapping("dept-age")
    public List<Employee> getEmployeesByDepartmentAndAgeLessThan(@RequestParam String department,
            @RequestParam int age) {
        return employeeRepo.findByDepartmentAndAgeLessThan(department, age);
    }
}
