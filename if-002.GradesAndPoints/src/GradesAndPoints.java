
import java.util.Scanner;

public class GradesAndPoints {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Type the points [0-60]: ");
        int grade = reader.nextInt();

        if (grade <= 29) {
            System.out.printf("Fail");
        } else if (grade >= 29 && grade <= 34) {
            System.out.printf("Your grade is 1");
        } else if (grade >= 35 && grade <= 39) {
            System.out.printf("Your grade is 2");
        } else if (grade >= 40 && grade <= 44) {
            System.out.printf("Your grade is 3");
        } else if (grade >= 45 && grade <= 49) {
            System.out.printf("Your grade is 4");
        } else if (grade >= 50 && grade <= 60) {
            System.out.printf("Your grade is 5");
        }
    }
}
