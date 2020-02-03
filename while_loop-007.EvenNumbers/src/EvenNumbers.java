
public class EvenNumbers {

    public static void main(String[] args) {
        // Write your code here
        int n = 100;

        for (int i = 1; i <= n; i++) {
            //if number%2 == 0 it means its an even number
            if (i % 2 == 0) {
                System.out.println(i + " ");
            }
        }
    }
}