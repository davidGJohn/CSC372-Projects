public class AccountTest {
    public static void main(String[] args) {
        // Test BankAccount
        BankAccount account = new BankAccount();
        account.setFirstName("David");
        account.setLastName("John");
        account.setAccountID(12345);
        account.deposit(1000.0);
        account.withdrawal(500.0);
        account.accountSummary();
        System.out.println("-------------");
        // Test CheckingAccount
        CheckingAccount checkingAccount = new CheckingAccount(2.5);
        checkingAccount.setFirstName("David");
        checkingAccount.setLastName("John");
        checkingAccount.setAccountID(54321);
        checkingAccount.deposit(500.0);
        checkingAccount.withdrawal(600.0);
        checkingAccount.displayAccount();
    }
}