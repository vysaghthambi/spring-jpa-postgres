package com.example.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.model.CourseContent;

@Repository
public interface CourseContentRepository extends JpaRepository<CourseContent, Integer> {

    public CourseContent findById(int id);

}
