import java.io.*;
import java.util.ArrayList;
public class CleanDictionary {
    public static void main(String[] args) {
        String filePath = "src\\words.txt";
        ArrayList<String> dictionary = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                dictionary.add(line.trim());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            System.out.println("Error reading file!");
        }
        catch (Exception e){
            System.out.println("Something went wrong!");
        }
        dictionary.sort(String::compareToIgnoreCase);
        ArrayList<String> listWithoutDuplicates = new ArrayList<>();
        for (String element : dictionary) {
            if (!listWithoutDuplicates.contains(element)) {
                listWithoutDuplicates.add(element);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String item : listWithoutDuplicates) {
                writer.write(item);
                writer.newLine();
            }
            System.out.println("ArrayList written to file successfully.");
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Something went wrong!");
        }
    }
}
