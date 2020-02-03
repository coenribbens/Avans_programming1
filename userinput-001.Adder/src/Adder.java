
import java.util.Scanner;

public class Adder {

    public static void main(String[] args) {
        int firstInteger;
        int secondInteger;
        Scanner reader = new Scanner(System.in);
        //Enter thef first integer and put that number into a variable
        System.out.println("Please enter your first integer:");
       firstInteger = reader.nextInt();

        System.out.println("Please enter the second integer:");
        secondInteger = reader.nextInt();

        int result = firstInteger + secondInteger;
        System.out.println("Sum of the numbers:"  + result );

    }
}
