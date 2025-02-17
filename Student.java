package CCSD_Project;

import java.util.ArrayList;

public class Student extends Person{
    
    private String studentId;
    private ArrayList<Double> grades;

    // Constructor for Student
    public Student(String StudentName, int personId, String studentId) {
        super(StudentName, personId);
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    // Getter for studentId
    public String getStudentId() {
        return studentId;
    }

    // Getter for grades
    public ArrayList<Double> getGrades() {
            return grades;
    }
    
    // Setter for studentId
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Setter for grades
    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Grades must be between 0 to 100");
        } else
            grades.add(grade);
        System.out.println("Grade Added.");
    }

    // Function to calculate average grade
    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
