package CCSD_Project;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    // Function to export data to a file
    public void exportDataFile(String filename, ArrayList<Student> students){
        try (PrintWriter w = new PrintWriter(new FileWriter(filename))){
            for(Student s : students) {
                w.println(s.getStudentId() + ","
                        +  s.getName() + ","
                        +  s.getPersonId() + ","
                        +  s.getGrades().toString());
            }
            System.out.println("Student data succesfully exported to " + filename);
        } catch (IOException e) {
            System.out.println("Got error while exporting data: " + e.getMessage());
        }
    }

    // Function to import data from a file
    public ArrayList<Student> importDataFromFile(String filename) {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                //Validate valid format
                if(parts.length != 4){
                    System.out.println("Invalid data format in line: " + line);
                    continue;
                }

                String studentId = parts[0];
                String name = parts[1];
                int personId;
                try {
                    personId = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid person ID: " + parts[2]);
                    continue;
                }
                String gradesString = parts[3].replace("[", "").replace("]", "");
                Student student = new Student(name, personId, studentId);
                 for (String grade : gradesString.split(" ")) {
                    if (!grade.isEmpty()) {
                        try {
                            student.addGrade(Double.parseDouble(grade));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid grade: " + grade);
                        }
                    }
                }
                
                students.add(student);
                System.out.println("Imported student list: " + studentId + ", " + name + ", " + personId + ", " + gradesString);
            }
            System.out.println("Student data successfully imported from " + filename);
            
        } catch (IOException e) {
            System.out.println("Got error while importing data: " + e.getMessage());
        }
        return students;
    }
}
