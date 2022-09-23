package com.example.springjpa.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springjpa.model.Course;
import com.example.springjpa.model.CourseContent;
import com.example.springjpa.pojos.CourseRequest;
import com.example.springjpa.repository.CourseContentRepository;
import com.example.springjpa.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private CourseContentRepository courseContentRepo;

    public Course addCourseWithContents(CourseRequest courseRequest) {

        Course course = new Course();
        course.setId(courseRequest.id);
        course.setCourse(courseRequest.course);
        course.setCourseContents(courseRequest.courseContents
                .stream()
                .map(courseContent -> {
                    CourseContent cContent = courseContent;
                    if (cContent.getId() > 0) {
                        cContent = courseContentRepo.findById(cContent.getId());
                    }
                    cContent.addCourse(course);
                    return cContent;
                })
                .collect(Collectors.toSet()));

        return courseRepo.save(course);
    }
}
