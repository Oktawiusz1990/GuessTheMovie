import java.util.Scanner;

public class Movies {
    public static String getTittleHidden(String titleToGuess) {
        String tittleHidden = titleToGuess.replaceAll(".", "_");
        System.out.println(tittleHidden);
        return tittleHidden;
    }

    public static int getLinesCounter(Scanner fileScanner) {
        int linesCounter = 0;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            linesCounter += 1;
        }
        return linesCounter;
    }

    public static String getTitleToGuess(int linesCounter, String[] moviesTab) {
        String titleToGuess = moviesTab[(int) (Math.random() * linesCounter) + 1];
        System.out.println("Tittle to guess:");
        return titleToGuess;
    }

    public static void getMoviesTittleTable(String[] moviesTab, Scanner fileScanner1) {
        while (fileScanner1.hasNextLine()) {
            for (int i = 0; i < moviesTab.length; i++) {
                String line1 = fileScanner1.nextLine();
                moviesTab[i] = line1;
            }
        }
    }
}
