import java.util.ArrayList;
import java.util.Scanner;

public class FirstCharacters {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Type your name:");
        String name = reader.nextLine();
        while(name.length() > 3) {
            char[] separatedCharacters = separateCharacters(name);
            for(int i = 0; i > separatedCharacters.length; i++)

            System.out.println(i + ". " + "character: " + separatedCharacters[i]);

        }
    }

    public static char[] separateCharacters(String text) {
      char[3] firstFourChars = text.valueOf(0,3);

         return threeChars;
    }
}
