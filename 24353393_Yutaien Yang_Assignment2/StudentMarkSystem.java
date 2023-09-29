
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
                String input = scanner.nextLine();//Store the content of the file
                String[] parts = input.split(",");//Break the content into pieces 
                
                if (lineCount == 0) {//Read the fist line and store the unit name
                    String unitName = parts[0] ;
                    System.out.println(unitName);
                    System.out.println();
                }
                
                lineCount++;
                
                if (lineCount < 3) {//Skip the first two lines
                    continue;
                }
                
                String studentName = parts[0] + " " + parts[1];
                String studentID = parts[2];
                double assignment1;
                double assignment2;
                double assignment3;
                double averageMark;
                
                
                if (parts[3].isEmpty()) {//If the position is empty, set it to 0 points
                    assignment1 = 0.0;
                } else {
                    assignment1 = Double.parseDouble(parts[3]);
                }
                if (parts[4].isEmpty()) {//If the position is empty, set it to 0 points
                    assignment2 = 0.0;
                } else {
                    assignment2 = Double.parseDouble(parts[4]);
                }
                if (parts[5].isEmpty()) {//If the position is empty, set it to 0 points
                    assignment3 = 0.0;
                } else {
                    assignment3 = Double.parseDouble(parts[5]);
                }
                
                System.out.println("Student Name: " + studentName);
                System.out.println("Student ID: " + studentID);
                System.out.print("Assignment1: " + assignment1 + "  ");
                System.out.print("Assignment2: " + assignment2 + "  ");
                System.out.print("Assignment3: " + assignment3);
                System.out.println(); 
                
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + "prog5001_students_grade_2022.csv");
        } 
    }
}
