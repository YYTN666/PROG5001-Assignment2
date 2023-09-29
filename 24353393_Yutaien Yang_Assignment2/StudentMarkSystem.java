
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
                
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + "prog5001_students_grade_2022.csv");
        } 
    }
}
