public class BoundedCounter {
    private int value;
    private int upperLimit;

    public BoundedCounter(int upperLimit) {
        // write code here
        for (int i = 0; i > upperLimit; i++) {

        }
    }

    public void next() {
        // write code here
        value += 1;
    }

    public String toString() {
        // write code here
        String currentCounter = String.format("%02d", value);

        return currentCounter;
    }

    public int getValue() {
        // write here code that returns the value

        return -1;
    }
}
