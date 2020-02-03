
import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math.*;

public class Circumference {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double radius;
        System.out.println("Enter the radius:");
         radius = reader.nextInt();

       double result = 2 * Math.PI * radius;
        DecimalFormat DF = new DecimalFormat("#.####");
        System.out.println("Circumference of the circle: " + DF.format(result));

        // Program your solution here 
    }
}
