import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class PasswordRandomizer {
    // Define the variables
    private int requiredPasswordLength;
    Random random = new Random();

    public PasswordRandomizer(int length) {
        // Initialize the variable
        this.requiredPasswordLength = length;
    }

    public String createPassword() {
        // write code that returns a randomized password
         String alphaNumChars = "abcdefghijklmnopqrstuvwxyz";
        String password = "";

        for (int i = 0; i < requiredPasswordLength; i++) {
            int randomIndex = random.nextInt(alphaNumChars.length());
            password += alphaNumChars.charAt(randomIndex);
        }

        return password;
    }
}
