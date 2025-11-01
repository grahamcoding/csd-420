/**
 * Daniel Graham
 * Module 2 Write/Read Data Files
 * 11/01/2025
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadDataFile {
    public static void main(String[] args) {
        String fileName = "DanielGraham_datafile.dat"; // same name

        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);

            System.out.println("Contents of the file:\n");

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}