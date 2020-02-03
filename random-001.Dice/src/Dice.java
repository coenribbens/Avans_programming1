import java.util.Random;

public class Dice {
    private Random random = new Random();
    private int numberOfSides;

    public Dice(int numberOfSides) {
        // Initialize here the number of sides
        this.numberOfSides = numberOfSides;
        random = new Random();

    }

    public int roll() {
        // create here a random number belongig to range 1-numberOfSided
        int rolledNumber = random.nextInt((numberOfSides - 1) + 1) + 1;

        return rolledNumber;
    }
}
