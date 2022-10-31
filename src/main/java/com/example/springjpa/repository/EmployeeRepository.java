package com.example.springjpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findById(int id);

    List<Employee> findByEmployeeName(String name);

    List<Employee> findByDepartmentAndAgeLessThan(String department, int age);

    // Derived queries example

    List<Employee> findTop5ByAge(int age);

    List<Employee> findByAgeBetween(int startAge, int endAge);

    List<Employee> findByAgeIn(List<Integer> ageGroup);

    List<Employee> findByJoiningDateAfter(Date date);

    List<Employee> findByJoiningDateBefore(Date date);

    List<Employee> findByJoiningDateBetween(Date startDate, Date endDate);

    List<Employee> findByJoiningDateBetweenAndDepartment(Date startDate, Date endDate, String department);

    List<Employee> findByLeftOnIsNull();

    List<Employee> findByEmployeeNameEquals(String employeeName);

    List<Employee> findByEmployeeNameIsNot(String employeeName);

    List<Employee> findByEmployeeNameIsNull(String employeeName);

    List<Employee> findByEmployeeNameIsNotNull(String employeeName);

    List<Employee> findByEmployeeNameOrderByJoiningDateAsc(String employeeName);

    List<Employee> findByEmployeeNameOrderByJoiningDateDesc(String employeeName);

    List<Employee> findByLeftJobTrue();

    List<Employee> findByLeftJobFalse();

    List<Employee> findByLeftJob(boolean leftJob);

}
