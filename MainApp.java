/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package CCSD_Project;
import java.util.Scanner;

/**
 *
 * @author M.S.I
 */
public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeManager gm = new GradeManager();
        FileManager fm = new FileManager();

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("=============================================");
            System.out.println("              Student Grade Manager          ");
            System.out.println("=============================================");
            System.out.println("1. Add a New Student");
            System.out.println("2. Enter Grades for a Student");
            System.out.println("3. View Grades for  Existing Student");
            System.out.println("4. View a Student's Report (Including Average)");
            System.out.println("5. View All Student");
            System.out.println("6. Export Data to File");
            System.out.println("7. Import Data from File");
            System.out.println("8. Exit");
            System.out.println("=============================================");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            String studentId;

            switch (choice) {
                case 1:
                    System.out.println("Enter Student name: ");
                    String name = sc.nextLine();
                    System.out.println("Person ID");
                    int personId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student ID: ");
                    studentId = sc.nextLine();
                    gm.addStudent(new Student(name, personId, studentId));
                    break;

                case 2:
                    System.out.println("Enter Student ID: ");
                    studentId = sc.nextLine();
                    System.out.println("Enter Grade: ");
                    double grade = sc.nextDouble();
                    gm.addGrade(studentId, grade);
                    break;
                case 3:
                    System.out.println("Enter Student ID: ");
                    studentId = sc.nextLine();
                    gm.displayGrade(studentId);
                    break;
                case 4:
                    System.out.println("Enter Student ID: ");
                    studentId = sc.nextLine();
                    gm.displayStudentRep(studentId);
                    break;
                case 5:
                    System.out.println("================================ All Student Report =================================");
                    gm.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Enter the file name: ");
                    String exportName = sc.nextLine();
                    fm.exportDataFile(exportName, gm.getStudentList());
                    break;
                case 7:
                    System.out.println("Enter the file name: ");
                    String importName = sc.nextLine();
                    fm.importDataFromFile(importName);
                    break;
                case 8:
                    System.out.println("Are you sure you want to exit? (yes/no)");
                    String confirmExit = sc.nextLine();
                    if (confirmExit.equalsIgnoreCase("yes")) {
                        isRunning = false;
                        System.out.println("Exiting......");
                        sc.close();
                    }
                    break;

                default:
                    System.out.println("Please Try Again.");
            }

        }
    }

}
