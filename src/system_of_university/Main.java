/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_of_university;

import java.util.Scanner;

/**
 *
 * @author sara
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        College myCollege = new College("Software Industry & Multimedia");
        myCollege.addCourse(new Course("Programming", "CS101", 3));

        while (true) {
            System.out.println("\n========================================");
            System.out.println("   College Management System (12 Tasks)  ");
            System.out.println("========================================");
            System.out.println("1.  Add New Student to College");
            System.out.println("2.  Add New Course to College");
            System.out.println("3.  Add New Lecturer to College");
            System.out.println("4.  Register Course for Student");
            System.out.println("5.  Assign Course to Lecturer");
            System.out.println("6.  Remove Course from Student");
            System.out.println("7.  Display Student Info & GPA");
            System.out.println("8.  Display All Courses for a Student");
            System.out.println("9.  Display Lecturer Info");
            System.out.println("10. Display All Students in College");
            System.out.println("11. Display All Courses in College");
            System.out.println("12. Exit Program");
            System.out.print("Select an option (1-12): ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = input.nextLine();
                    System.out.print("Address: ");
                    String addr = input.nextLine();
                    System.out.print("Phone: ");
                    long ph = input.nextLong();
                    input.nextLine();
                    System.out.print("Email: ");
                    String mail = input.nextLine();
                    System.out.print("Major: ");
                    String maj = input.nextLine();
                    System.out.print("GPA: ");
                    double gpa = input.nextDouble();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    Student newStudent = new Student(name, addr, ph, mail, maj, gpa, year);
                    myCollege.addStudent(newStudent);
                    System.out.println("-----------------------------------------------");
                    System.out.println("Done! Student added successfully.");
                    System.out.println("the generated Student ID is: " + newStudent.getId());
                    System.out.println("----------------------------------------------");
                    break;

                case 2:
                    System.out.print("Course Name: ");
                    String cn = input.nextLine();
                    System.out.print("Course Code: ");
                    String cc = input.nextLine();
                    System.out.print("Hours: ");
                    int hr = input.nextInt();
                    myCollege.addCourse(new Course(cn, cc, hr));
                    System.out.println("Course '" + cn + "' is now available in the college.");
                    break;

                case 3:

                    System.out.print("Lecturer Name: ");
                    String ln = input.nextLine();

                    System.out.print("Address: ");
                    String lAddr = input.nextLine();

                    System.out.print("Email: ");
                    String lEmail = input.nextLine();

                    System.out.print("Phone Number: ");
                    long lPhone = input.nextLong();
                    input.nextLine();

                    System.out.print("Department: ");
                    String dep = input.nextLine();

                    double salary;
                    do {
                        System.out.print("Salary: ");
                        salary = input.nextDouble();
                        input.nextLine();

                        if (salary < 0) {
                            System.out.println("Error: Salary cannot be negative. Please try again.");

                        }
                    } while (salary < 0);

                    Lecturer newLecturer = new Lecturer(ln, lAddr, lPhone, lEmail, dep, salary);
                    myCollege.addLecturer(newLecturer);
                    System.out.println("-----------------------------------------------");
                    System.out.println("Done! lecturer added successfully.");
                    System.out.println("the generated Student ID is: " + newLecturer.getId());
                    System.out.println("----------------------------------------------");

                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int sid = input.nextInt();
                    input.nextLine();
                    System.out.print("Course Code: ");
                    String ccode = input.nextLine();
                    myCollege.registerCourseForStudent(sid, ccode);
                    System.out.println("Registration complete! The course has been added to the student's list.");
                    break;

                case 5:
                    System.out.print("Enter Lecturer ID: ");
                    long lID = input.nextLong();
                    input.nextLine();

                    System.out.print(" Enter Course Code: ");
                    String crsCode = input.nextLine();
                    myCollege.registerCourseForLecturer(lID, crsCode);
                    System.out.println("Registration complete! The course has been added to the lecturer's list.");
                    break;

                case 6:
                    System.out.print("Student ID: ");
                    int stId = input.nextInt();
                    input.nextLine();
                    System.out.print("Course Code to Remove: ");
                    String rCode = input.nextLine();
                    Student s = myCollege.findStudent(stId);
                    if (s != null) {
                        s.dropCourse(rCode);
                    } else {
                        System.out.println("Student not found!");
                    }
                    System.out.println("Course removed from student's list.");
                    break;

                case 7:
                    System.out.print("Student ID: ");
                    int fId = input.nextInt();
                    Student foundS = myCollege.findStudent(fId);
                    if (foundS != null) {
                        foundS.displayinfo();
                    } else {
                        System.out.println("Not found!");
                    }
                    System.out.println("--- End of Student Information ---");
                    break;

                case 8:
                    System.out.print("Student ID: ");
                    int pId = input.nextInt();
                    Student st = myCollege.findStudent(pId);
                    if (st != null) {
                        st.displayAllCourses();
                    }
                    System.out.println("--- End of Student Course List ---");
                    break;

                case 9:
                    myCollege.displayAllLecturers();
                    System.out.println("--- End of Lecturer Information ---");
                    break;

                case 10:
                    myCollege.displayAllStudents();
                    System.out.println("Total student records displayed.");
                    break;

                case 11:
                    myCollege.displayAllCourses();
                    System.out.println("All available courses listed above.");
                    break;

                case 12:

                    System.out.println("Saving data and exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Option!");
            }

        }
    }
}
