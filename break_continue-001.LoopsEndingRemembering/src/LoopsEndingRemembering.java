import java.util.Scanner;

public class LoopsEndingRemembering {
    public static void main(String[] args) {
        // program in this project exercises 36.1-36.5
        // actually this is just one program that is split in many parts
        
        Scanner reader = new Scanner(System.in);

        int userInput = 0;
        int totalSum = 0;
        int count = 0;
        double averageNumbers = 0;
        int evenNumbers = 0;
        int oddNumbers = 0;


        System.out.println("Type numbers: ");
        while(userInput != -1) {
            userInput = reader.nextInt();
            if(userInput == -1) {
                break;
            }
            count++;
            totalSum = totalSum + userInput;
            if(userInput %2 == 0) {
           evenNumbers++;
            }else if(userInput %2 == 1){
                oddNumbers++;
            }

        }
        averageNumbers = (double) totalSum / count;

        System.out.println("Thank you and see you later!");
        System.out.println("The sum is: " + totalSum);
        System.out.println("How many numbers: " + count);
        System.out.println("Average:" + averageNumbers);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
    }
}
