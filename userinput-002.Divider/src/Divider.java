
import java.util.Scanner;

public class Divider {

    public static void main(String[] args) {
        double firstInteger;
        double secondInteger;
        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter a number:");
        firstInteger = reader.nextDouble();

        System.out.println("Please enter the second number:");
        secondInteger = reader.nextDouble();

        double result = firstInteger / secondInteger;
        System.out.println("Division: " + firstInteger + "/" + secondInteger + "=" + result);
        // Implement your program here. Remember to ask the input from user.
    }
}
