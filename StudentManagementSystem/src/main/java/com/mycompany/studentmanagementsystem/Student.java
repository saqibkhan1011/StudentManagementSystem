/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private String studentID;
    private String name;
    private int age;
    private ArrayList<Course> courses;
    private double grade;

    public Student(String studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.removeStudent(this);
    }

    public void viewCourses() {
        System.out.println("Courses for " + name + ":");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }
}
