public class LyyraCard {
    private double balance;

    public LyyraCard(double balanceAtStart) {
        // write code here
        this.balance = balanceAtStart;
    }

    public String toString() {
        // write code here

        return "The card has " + balance + " euros";
    }
    public void payEconomical() {
        // write code here
        if(balance >= 2.50) {
            balance = (balance - 2.50);
        }
    }

    public void payGourmet() {
        // write code here
        if(balance >= 4.00) {
            balance = (balance - 4.00);
        }
    }

    public void loadMoney(double amount) {
        // write code here
        if(amount < 150 && amount > 0) {
            balance += amount;
            if(balance > 150) {
                balance = 150;
            }
        }else{

        }
    }




}
