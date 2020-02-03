
import java.util.Scanner;

public class BiggerNumber {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int firstNumber;
        int secondNumber;

        System.out.println("Type a number: ");
        firstNumber = reader.nextInt();

        System.out.printf("Type another number: ");
        secondNumber = reader.nextInt();

        System.out.println("The bigger number of the two numbers given was: " + Math.max(firstNumber,secondNumber));
    }
}
