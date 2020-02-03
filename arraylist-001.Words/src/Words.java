import java.util.ArrayList;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<String>();
        String userInput = "";
        String typedWord;
        while (true) {
;  System.out.println("Type a word: ");
            typedWord = reader.nextLine();
            if (!userInput.isEmpty()) {
                words.add(typedWord);

            } else if(userInput.isEmpty()) {
                System.out.println("You typed the following words:");
                for (String allWords : words) {
                    System.out.println(allWords);
                }
            }


        }
    }
}
