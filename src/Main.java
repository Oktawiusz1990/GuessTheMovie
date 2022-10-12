import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("mov.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);

        int linesCounter = Movies.getLinesCounter(fileScanner);
        String[] moviesTab = new String[linesCounter];

        Scanner fileScanner1 = new Scanner(file);
        Movies.getMoviesTittleTable(moviesTab, fileScanner1);

        String titleToGuess = Movies.getTitleToGuess(linesCounter, moviesTab);
        String tittleHidden = Movies.getTittleHidden(titleToGuess);
        char[] tittleHiddenArrays = tittleHidden.toCharArray();

        int chance = 20;

        String writtenLetters = "";

        System.out.println("------Guess the title of the movie------\n");
        System.out.println("Number of movies: " + linesCounter);
        System.out.println("Remember - space bar (whitespace) is also sign :) ");
        System.out.println("\nTittle to guess\n" + tittleHidden);

        if (GameLogic.startGame(titleToGuess, tittleHiddenArrays, chance, scanner, tittleHidden, writtenLetters))
            return;
        else
            System.out.println("GAME OVER");
            System.out.println("The answer: " + titleToGuess);
    }




}