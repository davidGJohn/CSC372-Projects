public class CheckingAccount extends BankAccount {
    private double interestRate;
    private static final double OVERDRAFT_FEE = 30.0;

    public CheckingAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdrawal(double amount) {
        if (getBalance() - amount < 0) {
            super.withdrawal(amount + OVERDRAFT_FEE);
            System.out.println("Overdraft fee of $" + OVERDRAFT_FEE + " has been charged.");
        } else {
            super.withdrawal(amount);
        }
    }

    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
