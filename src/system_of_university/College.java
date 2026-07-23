
package system_of_university;

/**
 *
 * @author sara
 */


import java.util.ArrayList;

/**
 *
 * @author sara
 */
public class College {

    private String CollegeName;
    private ArrayList<Student> Students;
    private ArrayList<Course> Courses;
    private ArrayList<Lecturer> Lecturers;

    public College(String CollegeName) {
        this.CollegeName = CollegeName;
        this.Students = new ArrayList<Student>();
        this.Courses = new ArrayList<Course>();
        this.Lecturers = new ArrayList<Lecturer>();
    }

    public String getCollegeName() {
        return CollegeName;
    }

    public void addCourse(Course Y) {
        Courses.add(Y);
    }

    public void addStudent(Student X) {
        Students.add(X);
    }

    public void addLecturer(Lecturer Z) {
        Lecturers.add(Z);
    }

    public Student findStudent(long studentID) {
        for (Student s : Students) {
            if (s.getId() == studentID) {
                return s;
            }
        }
        return null;
    }

    public Course findCourse(String courseCode) {
        for (Course c : Courses) {
            if (c.getCourseCode().equals(courseCode)) {
                return c;
            }
        }
        return null;
    }

    public Lecturer findLecturer(long lecturerID) {
        for (Lecturer l : Lecturers) {
            if (l.getId() == lecturerID) {
                return l;
            }
        }
        return null;
    }

    public void registerCourseForStudent(long studentID, String courseCode) {
        Student s = findStudent(studentID);
        Course c = findCourse(courseCode);
        if (s != null && c != null) {
            s.registerCourse(c);
            System.out.println("Course " + c.getCourseName() + " registered for student " + s.getName());
        } else {
            System.out.println("Student or Course not found");
        }
    }

    public void registerCourseForLecturer(long lecturerID, String courseCode) {
        Lecturer l = findLecturer(lecturerID);
        Course c = findCourse(courseCode);
        if (l != null && c != null) {
            l.addCourse(c);
            System.out.println("Course" + c.getCourseName() + "registered for Lecturer" + l.getName());
        } else {
            System.out.println("Lecturer or course not found");
        }
    }

    public void displayCollegeInformation() {
        System.out.println("College Name=" + this.CollegeName);
        System.out.println("Number of students:" + Students.size());
        System.out.println("Number of Courses:" + Courses.size());
        System.out.println("Number of Lecturers:" + Lecturers.size());
    }

    public void displayAllCourses() {
        System.out.println("All courses in college:");
        for (Course c : Courses) {
            c.displayInfo();
            System.out.println("-------------------------");
        }
    }

    public void displayAllStudents() {
        System.out.println("All students in college:");
        for (Student s : Students) {
            s.displayinfo();
            System.out.println("---------------------------");
        }
    }

    public void displayAllLecturers() {
        System.out.println("All lecturers in college:");
        for (Lecturer l : Lecturers) {
            l.displayinfo();
            System.out.println("-------------------------");
        }
    }

    public void displayStudentCourses(long studentID) {
        Student s = findStudent(studentID);
        if (s != null) {
            System.out.println("Courses currently taken by " + s.getName());
            s.displayAllCourses();
        } else {
            System.out.println(" StudentID " + studentID + " not found");
        }
    }

    public void displayLecturerCourses(long lecturerID) {
        Lecturer l = findLecturer(lecturerID);
        if (l != null) {
            System.out.println("Courses currently taught by Dr. " + l.getName());
            l.displayAllCourses();
        } else {
            System.out.println("LecturerID " + lecturerID + " not found");
        }
    }

}


