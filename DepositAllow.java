package BankManagement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DepositAllow extends javax.swing.JDialog {

    private Customer customer;
    private DaoBank bank;
	private JButton depositButton;
	private JButton cancelButton;
	private StringBuilder warnings;
	private AbstractButton amountField;
    
    /**
     * Creates new form Deposit
     */
    public DepositAllow(java.awt.Frame parent, boolean modal, DaoBank bank, Customer customer) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.bank = bank;
        this.customer = customer;
    }
    private void initComponents() {

        JLabel amountLabel = new javax.swing.JLabel();
        JTextField amountField = new javax.swing.JTextField();
        depositButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deposit Allows");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        amountLabel.setText("Deposit Amount:");
        getContentPane().add(amountLabel);
        getContentPane().add(amountField);

        depositButton.setText("Deposit");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });
        getContentPane().add(depositButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	   this.dispose();
    }//
    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {
        StringBuilder warnings = new StringBuilder();
    //}
    if (amountField.getText().isEmpty()) {
        warnings.append("Deposit amount is required.\n");
    } else {
        double amount = 0;
        //Verify the deposit is a positive number
        try {
            amount = DaoBank.round(Double.parseDouble(amountField.getText()), 2);
            int result = JOptionPane.showConfirmDialog(this, "Deposit $" + String.format("%.2f", amount) + " to the account?\nInterest Earned: $" + String.format("%.2f", (bank.checkInterest(customer.getAccount().getBalance(), amount) * amount)));
            if (result == JOptionPane.OK_OPTION) {
                try {
                    //Make the deposit
                    bank.deposit(customer.getAccount().getAccountNumber(), amount);
                    this.dispose();
                } catch (InvalidAmountException ex) {
                    warnings.append("Deposit amount is invalid.\n");
                }
                
            }
        } catch (NumberFormatException ex) {
            warnings.append("Deposit must be a number.\n");
       } 
    }
    if (warnings.length() > 0) {
        JOptionPane.showMessageDialog(this, warnings.toString(), "Deposit Warnings", JOptionPane.WARNING_MESSAGE);
    }
}//



}
