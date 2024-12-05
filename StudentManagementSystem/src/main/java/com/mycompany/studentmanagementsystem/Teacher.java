/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

class Teacher {
    private String teacherID;
    private String name;
    private ArrayList<Course> coursesTeaching;

    public Teacher(String teacherID, String name) {
        this.teacherID = teacherID;
        this.name = name;
        this.coursesTeaching = new ArrayList<>();
    }

    public void addCourse(Course course) {
        coursesTeaching.add(course);
    }

    public void assignGrade(Student student, double grade) {
        student.setGrade(grade);
        System.out.println("Assigned grade " + grade + " to " + student.getName());
    }

    public void displayCourses() {
        System.out.println("Courses taught by " + name + ":");
        for (Course course : coursesTeaching) {
            System.out.println(course.getCourseName());
        }
    }
}

