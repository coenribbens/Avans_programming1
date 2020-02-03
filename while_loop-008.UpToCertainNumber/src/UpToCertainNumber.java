
import java.util.Scanner;


public class UpToCertainNumber {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int i;

        System.out.printf("Until what number: ");
       int readUntilNumber = reader.nextInt();

        for(i = 1; i <= readUntilNumber; i++ ) {
            System.out.println(i);
        }
        // Write your code here
        
    }
}
