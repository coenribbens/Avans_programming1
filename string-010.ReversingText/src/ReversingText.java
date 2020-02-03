
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Scanner;

public class ReversingText {

    public static String reverse(String text) {
        // write your code here
        // note that method does now print anything, it RETURNS the reversed string
        String reverseString = reverse(text);

        return reverseString;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Type in your text: ");
        String reverseText = reader.nextLine();

        System.out.println("In reverse order: " + reverse(reverseText));
    }
}
