
import java.util.Scanner;

public class Usernames {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);


        System.out.printf("Enter your username: ");
        String userName = reader.nextLine();

        System.out.printf("Enter your password: ");
        String password = reader.nextLine();

        if (userName.matches("alex") && password.matches("mightyducks")) {
            System.out.println("You are now logged into the system!");

        } else if (userName.matches("emily") && password.matches("cat")) {
            System.out.println("You are now logged into the system!");

        }else {
            System.out.printf("Your username or password was invalid!");
        }
    }
}
