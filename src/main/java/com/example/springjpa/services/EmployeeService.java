package com.example.springjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springjpa.model.Employee;
import com.example.springjpa.repository.EmployeeRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> saveAllEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> findAllEmployeesById(List<Integer> ids) {
        return employeeRepository.findAllById(ids);
    }

    public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findEmployeesByName(String name) {
        return employeeRepository.findByEmployeeName(name);
    }

}
