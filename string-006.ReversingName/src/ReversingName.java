import java.util.Scanner;

public class ReversingName {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Type your name: ");
        String name = reader.nextLine();

        StringBuilder sb = new StringBuilder(name);

        System.out.println("In reverse order: " + sb.reverse());
    }
}
