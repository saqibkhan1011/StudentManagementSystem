/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;
class Course {
    private String courseID;
    private String courseName;
    private int creditHours;
    private ArrayList<Student> students;

    public Course(String courseID, String courseName, int creditHours) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void displayStudents() {
        System.out.println("Students in course " + courseName + ":");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseID() {
        return courseID;
    }
    public int getCreditHours(){
        return creditHours;
    }
}
