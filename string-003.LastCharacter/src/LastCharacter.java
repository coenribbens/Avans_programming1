import java.util.Scanner;


public class LastCharacter {


    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = reader.nextLine();
        System.out.println("Last character: " + lastCharacter(name));
    }

    public static char lastCharacter(String text) {
        int stringLength = text.length();
      char lastChar = text.charAt(stringLength - 1);

      return lastChar;
    }
}
