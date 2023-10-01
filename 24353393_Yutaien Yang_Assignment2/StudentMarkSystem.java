
/**
 * Write a description of class StudentMarkSystem here.
 *
 * @author (Yutaien Yang)
 * @version (20230929)
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class StudentMarkSystem
{

    public static void main (String[] args) {
        
        System.out.print("Please enter the file name: ");
        Scanner userInput = new Scanner(System.in);
        String fileName = userInput.nextLine();
        ArrayList<Student> studentList = new ArrayList<>();//Save the data into the Student class, which will be created in subsequent code
        String unitName = "";
        
        //Prevents errors if a file cannot be found
        try (Scanner scanner = new Scanner(new File(fileName))) {//read the file
            int lineCount = 0; //The valid data for the file starts on the third line, so set a counter
            
            while (scanner.hasNextLine()) {//Read line by line until there are no more lines
                lineCount++;
                String input = scanner.nextLine();//Store the content of the file
                String[] parts = input.split(",");//Break the content into pieces 
                
                if (lineCount == 1) {//Read the fist line and store the unit name
                    unitName = parts[0] ;
                    
                } else if (lineCount >= 3) {//Skip the first two lines
                    String studentName = parts[0] + " " + parts[1];
                    String studentID = parts[2];
                    double assignment1;
                    double assignment2;
                    double assignment3; 

                    //The student scores section of the file is empty in some places, 
                    //and in other places there is no array at that location;
                    //the following method defines both cases as 0 scores
                    if (parts.length >= 4) {
                        if (parts[3].isEmpty()) {
                            assignment1 = 0.0;
                        } else {
                            assignment1 = Double.parseDouble(parts[3]);
                        }
                    } else {
                        assignment1 = 0.0;
                    }
                    
                    if (parts.length >= 5) {
                        if (parts[4].isEmpty()) {
                            assignment2 = 0.0;
                        } else {
                            assignment2 = Double.parseDouble(parts[4]);
                        }
                    } else {
                        assignment2 = 0.0;
                    }
                    
                    if (parts.length >= 6) {
                        if (parts[5].isEmpty()) {
                            assignment3 = 0.0;
                        } else {
                            assignment3 = Double.parseDouble(parts[5]);
                        }
                    } else {
                        assignment3 = 0.0;
                    }
                    
                    double totalMark = assignment1 + assignment2 + assignment3;
                    int ordinalNumber = lineCount - 2;
                    Student student = new Student(studentName, studentID, assignment1, assignment2, assignment3, totalMark, ordinalNumber);
                    studentList.add(student);
                    
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } 
        
        boolean exit = true;//Creating a Boolean variable for subsequent implementation of the exit function
        while (exit) {//Create a loop so that the menu continues to pop up after the user selects an option
           
           //Menu style and prompts the user to enter a selection
           System.out.println("Student Mark System");
           System.out.println(unitName);
           System.out.println();
           System.out.println("1. Student information and scores");
           System.out.println("2. Print students below the given threshold");
           System.out.println("3. Top5 and bottom5 students");
           System.out.println("4. exit");
           System.out.print("Please use the numbers 1-4 to enter the option: ");
           int option = userInput.nextInt();//Storing user input
           switch (option) {//Matching user input to options
               case 1:
                    studentInformation(studentList);
                    break;
               case 2:
                    System.out.print("Enter the threshold: ");// Prompt the user to enter a threshold value
                    double threshold = userInput.nextDouble();// Store the threshold
                    studentsBelowThreshold(studentList, threshold);
                    break;     
               case 3:
                    studentInformation(studentList);
                    break;
               case 4:
                    studentInformation(studentList);
                    break;
               default:
                    studentInformation(studentList);
                    break;
           }
           
        }
    }  
    
    public static void studentInformation(ArrayList<Student> studentList) {//To print students' information        

        for (Student student : studentList) {
            System.out.println("Student " + student.getOrdinalNumber() + " Name: " + student.getStudentName());
            System.out.println("Student " + student.getOrdinalNumber() + " ID: " + student.getStudentID());
            System.out.print("Assignment1: " + student.getAssignment1() + ", ");
            System.out.print("Assignment2: " + student.getAssignment2() + ", ");
            System.out.println("Assignment3: " + student.getAssignment3());
            System.out.println("Total: " + student.getTotalMark());
            System.out.println();
        }
        
        }
        
    public static void studentsBelowThreshold(ArrayList<Student> studentList, double threshold) {//To print students' information        
        System.out.println("Students with a total mark below the threshold " + threshold + ":");
        for (Student student : studentList) {
            if (student.getTotalMark() < threshold) {
                System.out.println(student.getStudentName());
            }
        }
        System.out.println();
        }
    }  

class Student {//Create a class to store the date of student
    
    private String studentName;
    private String studentID;
    private double assignment1;
    private double assignment2;
    private double assignment3;
    private double totalMark;
    private int ordinalNumber;
    
    public Student(String studentName, String studentID, double assignment1, double assignment2, double assignment3, double totalMark, int ordinalNumber) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
        this.totalMark = totalMark;
        this.ordinalNumber = ordinalNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public double getAssignment1() {
        return assignment1;
    }
    
    public double getAssignment2() {
        return assignment2;
    }
    
    public double getAssignment3() {
        return assignment3;
    }
    
    public double getTotalMark() {
        return totalMark;
    }
    
    public int getOrdinalNumber() {
        return ordinalNumber;
    }
}

        
    

