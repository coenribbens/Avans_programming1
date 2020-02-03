
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordsInAlphabeticalOrder {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // create here an ArrayList
        ArrayList<String> words = new ArrayList<String>();
        String userInput = "";

        while (true) {
            System.out.println("Type a word: ");
            userInput = reader.nextLine();
            if (userInput.isEmpty()) {
                Collections.sort(words);
                System.out.println("You typed the following words:");
                for(String typedWord : words ) {
                    System.out.println(typedWord);
                }
                break;
            } else {
                words.add(userInput);
            }

        }
    }
}
