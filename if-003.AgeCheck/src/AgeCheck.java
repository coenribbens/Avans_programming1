
import java.util.Scanner;

public class AgeCheck {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.printf("Please enter your age");
        int age = reader.nextInt();

        if(age > 120 || age < 0 ) {
            System.out.printf("Impossible!");
        }else{
            System.out.println("OK");
        }
    }


}