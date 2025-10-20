
# Java Hangman Game

A simple command-line implementation of the classic Hangman game written in Java.

## Description

This game randomly selects a word from a text file and allows players to guess letters one at a time. You have six chances to guess the word correctly before the game ends. The game displays an ASCII hangman as you make mistakes and shows your progress with underscores for unknown letters.

## Requirements

- Java 15+ (text blocks are used in the source; Java 17+ recommended)
- A word list file (words.txt)

## Project Structure

```
Hangman.iml
README.md
out\production\Hangman\Hangman.class
src\CleanDictionary.java
src\Hangman.java
src\words.txt
```

## Setup

The code reads the words.txt file using a relative path:

```
src\\words.txt
```

If your environment differs, update the `filePath` string near the top of `src\Hangman.java` or move your `words.txt` to that exact location.


## Build and Run (Windows PowerShell)

From the project root:

1) Compile
    ```
    javac -d out src\Hangman.java
    ```

2) Run
    ```
    java -cp out Hangman
    ```

Notes:
- Ensure `words.txt` is present at the path configured in `Hangman.java` (by default, the absolute path shown above).
- If you switch to a relative path like `src\\words.txt`, no extra classpath setup is needed for the data file; the program will read directly from the `src` folder.

## How to Play

1. Run the game.
2. A random word will be selected from the words.txt file.
3. Guess one letter at a time (case-insensitive).
4. You are allowed up to six wrong guesses.
5. The game ends when you either:
   - Guess all letters correctly (Win), or
   - Reach six wrong guesses (Lose).

## Example Session

```
===========================
Welcome to Java Hangman!
===========================

Word: _ _ _ _ _
Guess a letter: a
Correct Guess!

O
|

Word: a _ _ _ _
Guess a letter: z
Wrong Guess!
...
```

## Customizing the Words List

- Edit `src\words.txt` and put one word per line.
- Avoid spaces and punctuation; only letters are recommended.

## Utility: CleanDictionary

We include a small helper program to tidy up the dictionary:

- Location: `src\CleanDictionary.java`
- What it does:
  - Reads `src\words.txt`
  - Trims whitespace, sorts case-insensitively
  - Removes duplicates while preserving a one-per-line format
  - Writes the cleaned list back to `src\words.txt`
- How to run (from the project root):
  ```
  javac -d out src\CleanDictionary.java
  java -cp out CleanDictionary
  ```

## Changelog

- 2025-10-19: Expanded the word dictionary with 80+ advanced and challenging entries (e.g., dermatoglyphics, electroencephalograph, autochthonous, synecdoche, metonymy, catachresis, widdershins, brouhaha, flibbertigibbet, cattywampus). Maintained lowercase, one-per-line format. Added documentation for the CleanDictionary utility and updated the project structure.

## Troubleshooting

- File not found!: Ensure the `filePath` in `Hangman.java` points to your actual `words.txt` location, or place the file at that path.
- Error reading file!: Check file permissions and encoding (UTF-8 recommended).
- Java version errors: Verify `java -version` is 15 or higher.

## License

No license specified. Use at your own discretion.
