
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
        //userInput.close();
        ArrayList<String> studentList = new ArrayList<>();
        
        //Prevents errors if a file cannot be found
        try (Scanner scanner = new Scanner(new File(fileName))) {//read the file
            int lineCount = 0; //The valid data for the file starts on the third line, so set a counter
            
            while (scanner.hasNextLine()) {//Read line by line until there are no more lines
                lineCount++;
                String input = scanner.nextLine();//Store the content of the file
                String[] parts = input.split(",");//Break the content into pieces 
                
                if (lineCount == 1) {//Read the fist line and store the unit name
                    String unitName = parts[0] ;
                    System.out.println(unitName);
                    System.out.println();
                    
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
                    System.out.println("Student " + (lineCount - 2) + " Name: " + studentName);
                    System.out.println("Student " + (lineCount - 2) + " ID: " + studentID);
                    System.out.print("Assignment1: " + assignment1 + "  ");
                    System.out.print("Assignment2: " + assignment2+ "  ");
                    System.out.println("Assignment3: " + assignment3);
                    System.out.println("Totals: " + totalMark);
                    System.out.println();
                    
                    String student = studentName + "," + totalMark;
                    studentList.add(student);
                                    
                    }
                
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + "prog5001_students_grade_2022.csv");
        } 
        
        // Prompt the user to enter a threshold value
        System.out.print("Enter the threshold: ");
        double threshold = userInput.nextDouble(); // Store the threshold
        userInput.close(); // Close the input scanner

        System.out.println("Students with a total mark below the threshold " + threshold + ":");

        // Iterate through the studentList
        for (String student : studentList) {
            // Split the student string into parts using a comma
            String[] parts = student.split(",");
            String studentName = parts[0]; // Get the student's name from parts[0]
            double totalMark = Double.parseDouble(parts[1]); // Convert parts[1] to a double for totalMark

            // Check if the totalMark is below the threshold
            if (totalMark < threshold) {
            // Print the student's name 
                System.out.println(studentName + " ");
            }
        }

    }
}
