import java.util.Scanner;

public class GameLogic {

    public static boolean startGame(String titleToGuess, char[] tittleHiddenArrays,
                                    int chance, Scanner scanner,
                                    String guessedTittle, String writtenLetters) {

        while(chance > 0) {
            System.out.println("\nWrite Your letter:");

            String letter = scanner.nextLine();
            letter = letter.toLowerCase();
            char letterChar = letter.charAt(0);
            char[] tittle = new char[titleToGuess.length()];


            for (int k = 0; k < tittle.length; k++) {
                tittle[k] = titleToGuess.charAt(k);


                if (guessedTittle.contains(letter) || writtenLetters.contains(letter)) {
                    System.out.println("You have already this letter");
                    chance++;
                    break;
                }

                else if (tittle[k] == letterChar && tittle[k] != '_') {
                    tittleHiddenArrays[k] = letterChar;
                }
            }

            writtenLetters += letter;
            System.out.println();
            guessedTittle = String.valueOf(tittleHiddenArrays);
            System.out.println(guessedTittle);

            chance--;

            if (guessedTittle.equals(titleToGuess)) {
                System.out.println("CONGRATULATION! YOU WINN!\nChance left: " + chance);
                return true;
            }

            System.out.println("Chance left: " + chance);
        }
        return false;
    }
}
