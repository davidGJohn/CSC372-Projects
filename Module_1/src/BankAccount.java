public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    public BankAccount() {
        balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdrawal(double amount) {
        balance -= amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void accountSummary() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: $" + balance);
    }
}
