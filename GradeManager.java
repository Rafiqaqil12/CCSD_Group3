package CCSD_Project;

import java.util.ArrayList;

public class GradeManager {
    private ArrayList<Student> student;

    // Constructor for GradeManager
    public GradeManager() {
        this.student = new ArrayList<>();
    }

    // Function to add a student
     public void addStudent(Student s) {
         // Validate name
        if (s.getName() == null || s.getName().trim().isEmpty() || !s.getName().matches("[a-zA-Z ]+")) {
            System.out.println("Invalid name. Please enter a valid name without special characters.");
            return;
        }

        // Validate person ID
        if (s.getPersonId() <= 0) {
            System.out.println("Invalid person ID. Please enter a positive integer.");
            return;
        }

        // Validate student ID
        if (s.getStudentId() == null || s.getStudentId().trim().isEmpty() || !s.getStudentId().matches("[a-zA-Z0-9]+")) {
            System.out.println("Invalid student ID. Please enter a valid student ID without special characters.");
            return;
        }

        for (Student existingStudent : student) {
            if (existingStudent.getStudentId().equals(s.getStudentId())) {
                System.out.println("Student with ID " + s.getStudentId() + " already exists.");
                return;
            }
        }
        student.add(s);
        System.out.println("=============================================");
        System.out.println("          Student Added Successfully         ");
        System.out.println("=============================================");
        System.out.println("");
    }

    // Getter for student list
    public ArrayList<Student> getStudentList() {
        return student;
    }

    // Function to add a grade for a student
    public void addGrade(String studentId, double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
            return;
        }
        for (Student student : student) {
            if (student.getStudentId().equals(studentId)) {
                student.addGrade(grade);
                System.out.println("=============================================");
                System.out.println("           Grade added Successfully           ");
                System.out.println("=============================================");
                System.out.println("");
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    // Function to display grade
   public void displayGrade(String studentId) {
        for (Student s : student) {
            if (s.getStudentId().equals(studentId)) {
                if (s.getGrades().isEmpty()) {
                    System.out.println("No grades available for : " + s.getName() + ".");
                    
                } else {
                    System.out.println("");
                    System.out.println("Your are selected to display grades for " + "[" + s.getStudentId() + "]");
                    System.out.println("|--------------------------------------------------------|");
                    System.out.println("| Name             | Person ID | Student ID | Grades     |");
                    System.out.println("|------------------|-----------|------------|------------|");
                    System.out.printf("| %-16s | %-9d | %-10s | %-10s |\n",
                                  s.getName(), s.getPersonId(), s.getStudentId(), s.getGrades());
                }
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    // Function to get student by ID
    public Student getStudentById(String studentId) {
        for (Student student : student) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
        return null;
    }

    // Function to display all students
    public void displayAllStudents() {
        if (student.isEmpty()) {
            System.out.println("No students found in the list.");
        } else {
            for (Student s : student) {
                System.out.println("Name: " + s.getName());
                System.out.println("Person ID: " + s.getPersonId());
                System.out.println("Student ID: " + s.getStudentId());
                System.out.println("Student Grades: " + s.getGrades());
                System.out.println("Average Grade: " + s.calculateAverage());
            }
        }
    }

    // Function to display student's report
    public void displayStudentRep(String studentId) {
        for (Student s : student) {
            if (s.getStudentId().equals(studentId)) {
                System.out.println("");
                System.out.println("=============================================");
                System.out.println("                Student Report               ");
                System.out.println("=============================================");
                System.out.println("Name: " + s.getName());
                System.out.println("Person ID: " + s.getPersonId());
                System.out.println("Student ID: " + s.getStudentId());
                System.out.println("All Grades: " + s.getGrades());
                System.out.println("Average Grade: " + s.calculateAverage());
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }
}
