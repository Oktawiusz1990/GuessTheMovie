import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessTheMovie {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("mov.txt");
        Scanner fileScanner = new Scanner(file);

        int linesCounter = 0;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            linesCounter += 1;
        }
        System.out.println("------Guess the title of the movie------");
        System.out.println("Number of movies: " + linesCounter);
        System.out.println("Remember, space bar (whitespace) is also sign :) ");

        String[] moviesTab = new String[linesCounter];
        Scanner fileScanner1 = new Scanner(file);

            while (fileScanner1.hasNextLine()) {
                for (int i = 0; i < moviesTab.length; i++) {
                    String line1 = fileScanner1.nextLine();
                    moviesTab[i] = line1;
                }
            }

        String titleToGuess = moviesTab[(int) (Math.random() * linesCounter) + 1];
        System.out.println("Tittle to guess:");
//        System.out.println(titleToGuess);

        String tittleHidden = titleToGuess.replaceAll(".", "_");
        System.out.println(tittleHidden);
        char[] tittleHiddenArrays = tittleHidden.toCharArray();
        int chance = 20;
        Scanner scanner = new Scanner(System.in);
        String guessedTittle = tittleHidden;

        while(chance > 0) {

            System.out.println("\nWrite Your letter:");

            String letter = scanner.nextLine();
            letter = letter.toLowerCase();
            char letterChar = letter.charAt(0);

            char[] tittle = new char[titleToGuess.length()];

            for (int k = 0; k < tittle.length; k++) {
                tittle[k] = titleToGuess.charAt(k);

                if (guessedTittle.contains(letter)) {
                    System.out.println("You have already this letter");
                    chance++;
                    break;
                }

                else if (tittle[k] == letterChar && tittle[k] != '_') {
                    tittleHiddenArrays[k] = letterChar;
                }
            }

            System.out.println();
            guessedTittle = String.valueOf(tittleHiddenArrays);
            System.out.println(guessedTittle);

            chance--;

            if (guessedTittle.equals(titleToGuess)) {
                System.out.println("CONGRATULATION! YOU WINN!\nChance left: " + chance);
                return;
            }

            System.out.println("Chance left: " + chance);
        }
        System.out.println("GAME OVER");
    }
}