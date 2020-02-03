
import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String password = "carrot"; // Use carrot as password when running tests.
        String enteredPassword = "";
        String secret = "I can do this all day!";

        // Write your code here
        //Check if the password matches, ask again if it's wrong
        while (!enteredPassword.matches(password)) {
            System.out.printf("Type the password:");
            enteredPassword = reader.nextLine();
            if (!enteredPassword.matches(password)) {
                System.out.println("Wrong!");

            } else {
                System.out.println("Right!");
                System.out.println("The secret is " + secret );
            }
        }
    }
}
