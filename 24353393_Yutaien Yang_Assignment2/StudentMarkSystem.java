
/**
 * Write a description of class StudentMarkSystem here.
 *
 * @author (Yutaien Yang)
 * @version (20230929)
 */
import java.util.Scanner;
import java.io.*;

public class StudentMarkSystem
{
    public static void main (String[] args) {
        //Prevents errors if a file cannot be found
        try (Scanner scanner = new Scanner(new File("prog5001_students_grade_2022.csv"))) {//read the file
            int lineCount = 0; //The valid data for the file starts on the third line, so set a counter
            while (scanner.hasNextLine()) {//Read line by line until there are no more lines
                lineCount++;
                String input = scanner.nextLine();//Store the content of the file
                String[] parts = input.split(",");//Break the content into pieces 
                
                if (lineCount == 1) {//Read the fist line and store the unit name
                    String unitName = parts[0] ;
                    System.out.println("Name of unit: " + unitName);
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
                
                    }
                
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + "prog5001_students_grade_2022.csv");
        } 
    }
}
