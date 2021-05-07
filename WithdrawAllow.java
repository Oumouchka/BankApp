package BankManagement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WithdrawAllow extends javax.swing.JDialog {

    private Customer customer;
    private DaoBank bank;
	private JLabel amountLabel;
	private JTextField amountField;
	private JButton withdrawButton;
	private JButton cancelButton;

    /**
     * Creates Constructor
     */
    public WithdrawAllow(java.awt.Frame parent, boolean modal, DaoBank bank, Customer customer) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.bank = bank;
        this.customer = customer;
    }
    
    private void initComponents() {

        amountLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        withdrawButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Withdraw");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        amountLabel.setText("Withdraw Amount:");
        getContentPane().add(amountLabel);
        getContentPane().add(amountField);

        withdrawButton.setText("Withdraw");
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);
        pack();
    }// 
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	this.dispose();
    }
    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {
        StringBuilder warnings = new StringBuilder();
        if (amountField.getText().isEmpty()) {
            warnings.append("Withdraw amount is required.\n");
        } else {
            double amount = 0;
            try {
                amount = DaoBank.round(Double.parseDouble(amountField.getText()), 2);
                int result = JOptionPane.showConfirmDialog(this, "Withdraw $" + String.format("%.2f", amount) + " from the account?\nTransaction Fee: $" + String.format("%.2f", bank.getTransactionFee(customer.getAccount().getAccountType())));
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        bank.withdraw(customer.getAccount().getAccountNumber(), amount);
                        this.dispose();
                    } catch (InsufficientFundsException ex) {
                        warnings.append("Your Balance is Insufficient to complete transaction.\n");
                    }
                    
                }
            } catch (NumberFormatException ex) {
                warnings.append("Withdraw amount must be a number.\n");
            }
        }
        if (warnings.length() > 0) {
            JOptionPane.showMessageDialog(this, warnings.toString(), "Withdraw Warnings", JOptionPane.WARNING_MESSAGE);
        }   
        }

    }


