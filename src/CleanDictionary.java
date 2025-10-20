import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CleanDictionary {
    public static void main(String[] args) {
        String filePath = "src\\words.txt";
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String w = line.trim().toLowerCase();
                if (!w.isEmpty() && w.matches("[a-z]+")) {
                    words.add(w);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println("Something went wrong while reading: " + e.getMessage());
            return;
        }
        Set<String> unique = new HashSet<>(words);
        List<String> cleaned = new ArrayList<>(unique);
        cleaned.sort(String::compareTo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String item : cleaned) {
                writer.write(item);
                writer.newLine();
            }
            System.out.println("Dictionary cleaned and written to file successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Something went wrong while writing: " + e.getMessage());
        }
    }
}
