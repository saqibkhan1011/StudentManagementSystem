/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


class Admin {
    private String adminID;
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public Admin(String adminID, String name) {
        this.adminID = adminID;
        this.name = name;
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public Student findStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public Course findCourseByID(String courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public void displayAllCourses() {
        System.out.println("All Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }
public void saveDataToFile() {
        try (BufferedWriter studentWriter = new BufferedWriter(new FileWriter("students.txt"));
             BufferedWriter courseWriter = new BufferedWriter(new FileWriter("courses.txt"))) {

            // Save students
            for (Student student : students) {
                studentWriter.write(student.getStudentID() + "," + student.getName() + "," + student.getAge() + "\n");
            }

            // Save courses
            for (Course course : courses) {
                courseWriter.write(course.getCourseID() + "," + course.getCourseName() + "," + course.getCreditHours() + "\n");
            }

            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void loadDataFromFile() {
        try (BufferedReader studentReader = new BufferedReader(new FileReader("students.txt"));
             BufferedReader courseReader = new BufferedReader(new FileReader("courses.txt"))) {

            // Load students
            String line;
            while ((line = studentReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    students.add(new Student(id, name, age));
                }
            }

            // Load courses
            while ((line = courseReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    int creditHours = Integer.parseInt(parts[2]);
                    courses.add(new Course(id, name, creditHours));
                }
            }

            System.out.println("Data loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
