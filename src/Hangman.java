import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String filePath = "src\\words.txt";
        ArrayList<String> words= new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                words.add(line.trim());
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
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;
        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }
        String separator = "===========================";
        System.out.println(separator);
        System.out.println("Welcome to Java Hangman!");
        System.out.println(separator);
        int first=1;
        String stat = "";
        while (wrongGuesses < 6) {
            switch (first){
                case 0 -> {
                    for (int i = 0; i <= 25; i++) {
                        System.out.println();
                    }
                }
                case 1 -> first=0;
            }
            System.out.println(stat);
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.print("Word: ");
            for (char c: wordState) {
                System.out.print(c+" ");
            }
            System.out.println();
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);
            if (word.indexOf(guess) != -1) {
                stat = "Correct Guess!\n";
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }
            }
            else {
                stat = "Wrong Guess!\n";
                wrongGuesses++;
            }
            if (!wordState.contains('_')) {
                System.out.println(getHangmanArt(wrongGuesses));
                System.out.println("You Win!");
                break;
            }
        }
        if (wrongGuesses == 6) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("You lost the game!");
        }
        System.out.println(separator);
        System.out.println("The word was: " + word);
        System.out.println(separator);
        scanner.close();
    }
    private static String getHangmanArt(int wrongGuesses){
        return switch (wrongGuesses){
            case 0 -> """
                      
                      
                      
                      """;
            case 1 -> """
                      O
                      
                      
                      """;
            case 2 -> """
                      O
                      |
                      
                      """;
            case 3 -> """
                      O
                     /|
                     
                     """;
            case 4 -> """
                     O
                    /|\\
                    
                    """;
            case 5 -> """
                     O
                    /|\\
                    /
                    """;
            case 6 -> """
                     O
                    /|\\
                    / \\
                    """;
            default -> "";
        };
    }
}
