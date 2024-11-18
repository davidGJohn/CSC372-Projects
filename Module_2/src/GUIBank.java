import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIBank extends JFrame {
    private JTextField balanceField;
    private JTextField transactionField;
    private JLabel resultLabel;
    private double accountBalance = 0.0;

    public GUIBank() {
        setTitle("Bank Account Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(new JLabel("Initial Balance:"));
        balanceField = new JTextField();
        mainPanel.add(balanceField);

        mainPanel.add(new JLabel("Transaction Amount:"));
        transactionField = new JTextField();
        mainPanel.add(transactionField);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performTransaction(true);
            }
        });
        mainPanel.add(depositButton);
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performTransaction(false);
            }
        });
        mainPanel.add(withdrawButton);

        resultLabel = new JLabel("Balance: $0.00");
        mainPanel.add(resultLabel);

        add(mainPanel);
    }

    private void performTransaction(boolean isDeposit) {
        try {
            if (accountBalance == 0.0 && !balanceField.getText().isEmpty()) {
                accountBalance = Double.parseDouble(balanceField.getText());
            }

            double amount = Double.parseDouble(transactionField.getText());
            
            if (isDeposit) {
                accountBalance += amount;
            } else {
                if (amount > accountBalance) {
                    JOptionPane.showMessageDialog(this, "Insufficient funds!");
                    return;
                }
                accountBalance -= amount;
            }

            resultLabel.setText(String.format("Balance: $%.2f", accountBalance));
            transactionField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUIBank bankApp = new GUIBank();
            bankApp.setVisible(true);
        });
    }
}