
public class Accounts {

    public static void main(String[] args) {
        // Code in Account.Java should not be touched!
        // write your code here

        Account accountMatt = new Account("Matt's account", 1000.00);
        Account accountMine = new Account("My account", 0.00);

        accountMatt.withdrawal(100.00);
        accountMine.deposit(100.00);

        System.out.println(accountMatt);
        System.out.println(accountMine);
    }

}
