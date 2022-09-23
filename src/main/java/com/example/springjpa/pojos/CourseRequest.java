package com.example.springjpa.pojos;

import java.util.Set;

import com.example.springjpa.model.CourseContent;

public class CourseRequest {

    public int id;

    public String course;

    public Set<CourseContent> courseContents;
}
