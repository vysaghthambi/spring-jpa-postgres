package com.example.springjpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.pojos.CourseRequest;
import com.example.springjpa.services.CourseService;

@RequestMapping("/courses")
@RestController
public class CourseController {

    @Autowired
    public CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<?> addCourseWithContents(@RequestBody CourseRequest courseRequest) {
        return new ResponseEntity<>(courseService.addCourseWithContents(courseRequest), HttpStatus.OK);
    }
}
