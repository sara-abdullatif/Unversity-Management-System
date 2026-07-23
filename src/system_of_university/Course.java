
package system_of_university;

public class Course {

    private final String courseCode;
    private String courseName;
    private int courseHours;

    public Course(String courseName, String coursecode, int courseHours) {
        this.courseName = courseName;
        this.courseCode = coursecode;
        setCourseHours(courseHours);

    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseHours(int courseHours) {
        if (courseHours >= 0) {
            this.courseHours = courseHours;
        } else {
            System.out.println("error negative input");
        }
    }

    public String getCourseName() {
        return courseName;

    }

    public String getCourseCode() {
        return courseCode;
    }

    public double getCourseHours() {
        return courseHours;
    }

    public void displayInfo() {
        System.out.println("courseName: " + courseName);
        System.out.println("coursecode: " + courseCode);
        System.out.println("CourseHours: " + courseHours);

    }

}
