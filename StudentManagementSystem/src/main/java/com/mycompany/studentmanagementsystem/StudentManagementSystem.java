/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("A01", "Admin1");
        Teacher teacher = new Teacher("T01", "Mr. Smith");
        
        admin.loadDataFromFile();

        boolean running = true;
        while (running) {
            System.out.println("\n----- Student Management System -----");
            System.out.println("1. Add a Student");
            System.out.println("2. Add a Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. View Courses of a Student");
            System.out.println("5. Assign Grade to Student");
            System.out.println("6. Display All Students");
            System.out.println("7. Display All Courses");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int studentAge = scanner.nextInt();
                    scanner.nextLine();
                    admin.addStudent(new Student(studentID, studentName, studentAge));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Course ID: ");
                    String courseID = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Credit Hours: ");
                    int creditHours = scanner.nextInt();
                    scanner.nextLine();
                    admin.addCourse(new Course(courseID, courseName, creditHours));
                    System.out.println("Course added successfully.");
                    break;

                case 3:
                    System.out.print("Enter Student ID to enroll: ");
                    studentID = scanner.nextLine();
                    System.out.print("Enter Course ID to enroll in: ");
                    courseID = scanner.nextLine();
                    Student student = admin.findStudentByID(studentID);
                    Course course = admin.findCourseByID(courseID);
                    if (student != null && course != null) {
                        student.addCourse(course);
                        System.out.println("Student enrolled in course successfully.");
                    } else {
                        System.out.println("Invalid Student ID or Course ID.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to view courses: ");
                    studentID = scanner.nextLine();
                    student = admin.findStudentByID(studentID);
                    if (student != null) {
                        student.viewCourses();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to assign grade: ");
                    studentID = scanner.nextLine();
                    student = admin.findStudentByID(studentID);
                    if (student != null) {
                        System.out.print("Enter grade to assign: ");
                        double grade = scanner.nextDouble();
                        teacher.assignGrade(student, grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    admin.displayAllStudents();
                    break;

                case 7:
                    admin.displayAllCourses();
                    break;

                case 8:
                    running = false;
                    admin.saveDataToFile();
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
