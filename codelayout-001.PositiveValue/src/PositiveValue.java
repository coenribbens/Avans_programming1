
import java.util.Scanner;

public class PositiveValue {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int number;

        System.out.println("Type a number: ");
        number = reader.nextInt();

        if(number <= 0) {
            System.out.printf("is not positive.");
        }
        else {
            System.out.printf("The number is positive.");
            }
        // Type your program here:
    }
}
