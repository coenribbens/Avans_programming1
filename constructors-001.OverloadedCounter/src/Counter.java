public class Counter {
    private int startingValue;
    private boolean check;

    public Counter(int startingValue, boolean check){
    this.startingValue = startingValue;
    this.check = check;
    }

    public Counter(int startingValue) {
    this.startingValue = startingValue;
    }

    public Counter(boolean check) {
        this.check = check;
    }

    public Counter() {
    //Default constructor

    }


    public int value() {

        return this.startingValue;
    }
    //Start of methods
    public void increase() {
        startingValue += 1;
    }

    public void increase(int increaseAmount) {
        if (increaseAmount > 0) {
            startingValue += increaseAmount;
        }
    }

    public void decrease() {
        startingValue--;
        if (check && startingValue < 0) {
            startingValue = 0;
        }
    }

    public void decrease(int decreaseAmount) {
        if(decreaseAmount > 0) {
            startingValue -= decreaseAmount;
            if(check && startingValue < 0) {
                startingValue = 0;
            }
        }
    }

}
