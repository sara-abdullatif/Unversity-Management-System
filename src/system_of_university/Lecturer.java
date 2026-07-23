/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_of_university;

import java.util.ArrayList;

//  @author Retage
public class Lecturer extends Person {

    private static long counter = 100;
    private String department;
    private double salary;
    private ArrayList<Course> lecturerCourses;

    public Lecturer(String name, String address, long phone_number, String email, String department, double salary) {
        super(name, address, counter, phone_number, email);
        this.department = department;
        this.salary = salary;
        this.lecturerCourses = new ArrayList<>();
        this.id = counter++;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public ArrayList<Course> getLecturerCourses() {
        return lecturerCourses;
    }

    public void addCourse(Course course) {
        if (course != null) {
            lecturerCourses.add(course);
        }
    }

    public void dropCourse(String code) {
        boolean found = false;
        for (int i = 0; i < lecturerCourses.size(); i++) {

            if (lecturerCourses.get(i).getCourseCode().equals(code)) {

                lecturerCourses.remove(i);
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
        System.out.println("----- Lecturer Information -----");
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone_number: " + getPhone_number());
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }

    void displayAllCourses() {
        System.out.println("--- Courses List ---");
        for (Course c : lecturerCourses) {
            c.displayInfo();
            System.out.println("----------");
        }
    }
}
