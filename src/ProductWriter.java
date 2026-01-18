import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args) {
        boolean done = false;
        ArrayList <String> records = new ArrayList();
        do {
            String dataEntry = "";
            dataEntry += SafeInput.getNonZeroLenString(new Scanner(System.in), "Please input the item's ID");
            dataEntry += ", " + SafeInput.getNonZeroLenString(new Scanner(System.in), "Please input the item's name");
            dataEntry += ", " + SafeInput.getNonZeroLenString(new Scanner(System.in), "Please input the item's description");
            dataEntry += ", " + SafeInput.getDouble(new Scanner(System.in), "Please input the item's cost");
            records.add(dataEntry);

            done = SafeInput.getYNConfirm((new Scanner(System.in)), "Are you done inputting data? Please enter Y/y for yes and n/N for no");
        } while (!done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String line: records) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            System.out.println("Your file has been written!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
