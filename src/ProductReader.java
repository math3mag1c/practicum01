import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                System.out.printf("%-10s %-13s %-13s %-8s %n", "ID#", "ProductName", "Description", "Cost");
                System.out.println("=============================================");

                ArrayList<String[]> records = new ArrayList<>();
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] recer = line.split(",\\s*");
                    records.add(recer);
                }
                reader.close();

                for (String[] row : records) {
                    System.out.printf("%-10s %-13s %-13s %-8s %n", row[0], row[1], row[2], row[3]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("I/O Error!");
        }
    }
}
