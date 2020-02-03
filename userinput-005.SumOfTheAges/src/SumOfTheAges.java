
import java.util.Scanner;

public class SumOfTheAges {

    public static void main(String[] args) {
        String firstName;
        String secondName;
        int firstAge;
        int secondAge;
        int ageSum;
        Scanner reader = new Scanner(System.in);

        // Implement your program here
        //First name
        System.out.println("Type your name: ");
        firstName = reader.nextLine();
        //Age of first person
        System.out.printf("Type your age: ");
        firstAge = reader.nextInt();
        //A nextline so the reader doesn't skip over the next value
        reader.nextLine();
        //Name of the second person
        System.out.println("Type your name: ");
        secondName = reader.nextLine();
        //Age of second person
        System.out.printf("Type your age: ");
        secondAge = reader.nextInt();
       //Use addition to get the added ages
        ageSum = firstAge + secondAge;
//Print the names and ages
        System.out.printf(firstName + " and " + secondName + " are " + ageSum + " years old");

    }
}
