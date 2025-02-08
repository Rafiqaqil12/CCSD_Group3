
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author M.S.I
 */
public class Student extends Person{
    
   private String studentId;
   private ArrayList<Double> grades;

   public Student(String studentName, int personId, String studentId){
    super(studentName, personId);
    this.studentId = studentId;
    this.grades = new ArrayList<>();
   }

   public String getStudentId(){
    return studentId;
   }

   public void setStudentId(String studentId){
    this.studentId = studentId;
   }

   public void addGrade(double grade){
    grades.add(grade);
   }

    public ArrayList<Double> getGrades(){
        return grades;
    }

    public double calculateAverage(){
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
