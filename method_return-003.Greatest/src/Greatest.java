
public class Greatest {

    public static int greatest(int number1, int number2, int number3) {
    int maxValue = 0;

    if(number1 > number2 && number1 > number3) {

        maxValue = number1;
    }else if(number2 > number1 && number2 > number3) {
        maxValue = number2;
    }else if(number3 > number1 && number3 > number2) {
        maxValue = number3;
    }else{
        maxValue = number1;
    }
        return maxValue;
    }

    public static void main(String[] args) {
        int result = greatest(2, 7, 3);
        System.out.println("Greatest: " + result);
    }
}
