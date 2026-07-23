/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_of_university;

import java.util.ArrayList;

//  @author Shams
public class Student extends Person {

    private static long counter = 202600000;
    private String major;
    private double gpa;
    private int enrollmentYear;
    private ArrayList<Course> registeredCourses;

    public Student(String name, String address, long phone_number, String email,
            String major, double gpa, int enrollmentYear) {
        super(name, address, counter, phone_number, email);
        this.major = major;
        this.gpa = gpa;
        this.enrollmentYear = enrollmentYear;
        this.registeredCourses = new ArrayList<>();
        this.id = counter++;

    }

    public Student(String name, String address, long phone_number, String email,
            String major, int enrollmentYear) {

        super(name, address, counter, phone_number, email);
        this.major = major;
        this.gpa = 0.0;
        this.enrollmentYear = enrollmentYear;
        this.registeredCourses = new ArrayList<>();
        this.id = counter;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course != null) {
            registeredCourses.add(course);
        }
    }

    public void dropCourse(String code) {
        boolean found = false;

        for (int i = 0; i < registeredCourses.size(); i++) {
            if (registeredCourses.get(i).getCourseCode().equals(code)) {
                registeredCourses.remove(i);
                System.out.println("Course with code " + code + " has been dropped.");
                found = true;
                break;
            }
        }

        if (found == false) {
            System.out.println("Course code not found!");
        }
    }

    @Override
    public void displayinfo() {
        System.out.println("----- Student Information -----");
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + getId());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone_number());
        System.out.println("Email: " + getEmail());
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
        System.out.println("Enrollment Year: " + enrollmentYear);

    }

    void displayAllCourses() {
        System.out.println("--- Courses List ---");
        for (Course c : registeredCourses) {
            System.out.println("--------------------");
            c.displayInfo();
        }
    }
}
