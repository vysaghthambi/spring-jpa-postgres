package com.example.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    public Course findById(int id);
}
