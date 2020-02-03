
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type a year: ");
        int enteredYear = reader.nextInt();

        boolean isDivisibleBy4 = enteredYear % 4 == 0;
        boolean isDivisibleBy100 = enteredYear % 100 == 0;
        boolean isDivisibleBy400 = enteredYear % 400 == 0;


        if(isDivisibleBy100 == true && (isDivisibleBy400 == true || isDivisibleBy4 == true)) {
            System.out.println("The year is not a leap year.");
        }else{
            System.out.println("The year is a leap year.");
        }
     }
}
