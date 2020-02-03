
import java.util.Scanner;

public class Temperatures {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        // Write your code here.

    while(true) {

        System.out.println("Enter a value ");
        double numberToAdd = Double.parseDouble(reader.nextLine());

        if(numberToAdd > -30 && numberToAdd > 40) {
            System.out.printf("Please enter a value between -30 and +40");
        }else{
            Graph.addNumber(numberToAdd);
        }
    }

        // Graph is used as follows:
//        Graph.addNumber(7);
//        double value = 13.5;
//        Graph.addNumber(value);
//        value = 3;
//        Graph.addNumber(value);
        // Remove or comment out these lines above before trying to run the tests.
    }
}
