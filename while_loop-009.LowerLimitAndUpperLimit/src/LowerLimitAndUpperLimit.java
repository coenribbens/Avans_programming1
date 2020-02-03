
import java.util.Scanner;

public class LowerLimitAndUpperLimit {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // write your code here
        int i;
        System.out.printf("First: ");
        int startingNumber = reader.nextInt();

        System.out.printf("Second: ");
        int lastNumber = reader.nextInt();

        for (i = startingNumber; i <= lastNumber; i++) {
            System.out.println(i);
        }
    }
}
