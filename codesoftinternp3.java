import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class codesoftinternp3 extends JFrame implements ActionListener {
    private double balance = 1000.00;

    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton checkBalanceButton;
    private JButton depositButton;
    private JButton withdrawButton;

    public codesoftinternp3() {
        setTitle("ATM Machine Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        balanceLabel = new JLabel("Balance: $" + balance);
        amountField = new JTextField(10);
        checkBalanceButton = new JButton("Check Balance");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        checkBalanceButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(balanceLabel);
        panel.add(new JLabel(""));
        panel.add(new JLabel("Enter Amount: "));
        panel.add(amountField);
        panel.add(checkBalanceButton);
        panel.add(depositButton);
        panel.add(withdrawButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkBalanceButton) {
            JOptionPane.showMessageDialog(this, "Current Balance: $" + formatBalance(balance));
        } else if (e.getSource() == depositButton) {
            double amount = Double.parseDouble(amountField.getText());
            balance += amount;
            updateBalanceLabel();
            JOptionPane.showMessageDialog(this, "Deposited: $" + formatBalance(amount));
        } else if (e.getSource() == withdrawButton) {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= balance) {
                balance -= amount;
                updateBalanceLabel();
                JOptionPane.showMessageDialog(this, "Withdrawn: $" + formatBalance(amount));
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient Funds!");
            }
        }
    }

    private String formatBalance(double amount) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(amount);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: $" + formatBalance(balance));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new codesoftinternp3();
            }
        });
    }
}