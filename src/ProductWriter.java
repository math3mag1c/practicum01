import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        boolean done = false;
        ArrayList<String> records = new ArrayList<>();
        while (!done) {
            records.add(SafeInput.getRegExString(new Scanner(System.in), "Please input your data as \"ID (6-digit String), productName (String), description (String), Cost (double)\"", "\\d{6}, [^,]+, [^,]+, (?<=,\\s)-?\\d*\\.?\\d+"));
            done = SafeInput.getYNConfirm((new Scanner(System.in)), "Are you done inputting data? Please enter Y/y for yes and n/N for no");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ProductTestData.txt"))) {
            for (String line: records) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Your file has been written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
