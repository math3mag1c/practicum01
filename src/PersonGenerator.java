import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.CREATE;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        boolean done = false;
        ArrayList<String> records = new ArrayList<>();
        while (!done) {
            records.add(SafeInput.getRegExString(new Scanner(System.in), "Please input your data as \"ID (6-digit String), firstName, lastName, Title(String), YearOfBirth(4-digit int)\"", "(\\d{6}, [^,]+, [^,]+, [^,]+, \\d{4})"));
            done = SafeInput.getYNConfirm((new Scanner(System.in)), "Are you done inputting data? Please enter Y/y for yes and n/N for no");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PersonTestData.txt"))) {
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