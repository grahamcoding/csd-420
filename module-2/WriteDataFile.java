/**
 * Daniel Graham
 * Module 2 Write/Read Data Files
 * 11/01/2025
 */
 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteDataFile {

    public static void main(String[] args) {
        String fileName = "DanielGraham_datafile.dat"; // Change to your name
        Random random = new Random();

        try {
            // Append mode = true so data will be added instead of overwritten
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));

            // Write 5 random integers
            writer.println("Random Integers:");
            for (int i = 0; i < 5; i++) {
                int randomInt = random.nextInt(100); // random 0–99
                writer.print(randomInt + " ");
            }
            writer.println(); // new line

            // Write 5 random doubles
            writer.println("Random Doubles:");
            for (int i = 0; i < 5; i++) {
                double randomDouble = random.nextDouble() * 100; // random 0–99
                writer.print(randomDouble + " ");
            }
            writer.println();
            writer.println("---------------------------");

            writer.close();
            System.out.println("Data successfully written/appended to file.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}
