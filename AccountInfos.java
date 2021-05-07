package BankManagement;

import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.JLabel;

public class AccountInfos extends javax.swing.JDialog {
    private Component firstNameField;
	private Object lastNameField;
	private Object ssnField;
	private Object typeField;
	private Object accountNumberField;
	private Object balanceField;
	private Object interestField;
	private Component feeField;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel ssnLabel;
	private JLabel typeLabel;
	private JLabel accountNumberLabel;
	private JLabel balanceLabel;
	private JLabel interestLabel;
	private JLabel feeLabel;
	private AbstractButton okButton;

	/**
     * Creates new form with Account Informations
     */
    public AccountInfos(java.awt.Frame parent, boolean modal, DaoBank bank, Customer customer) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        
        setTitle(String.format("Account Information - %s %s", customer.getFirstName(), customer.getLastName()));
        
        ((AbstractButton) firstNameField).setText(customer.getFirstName());
        ((AbstractButton) lastNameField).setText(customer.getLastName());
        ((AbstractButton) ssnField).setText(customer.getSsn());
        ((AbstractButton) typeField).setText(customer.getAccount().getAccountType().name());
        ((AbstractButton) accountNumberField).setText(String.valueOf(customer.getAccount().getAccountNumber()));
        ((AbstractButton) balanceField).setText(String.format("$%.2f", customer.getAccount().getBalance()));
        ((AbstractButton) interestField).setText(String.valueOf(bank.checkInterest(customer.getAccount().getBalance(), 0) * 100) + "%");
        ((AbstractButton) feeField).setText(String.format("$%.2f", bank.getTransactionFee(customer.getAccount().getAccountType())));
    }
    
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JLabel();
        ssnLabel = new javax.swing.JLabel();
        ssnField = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        typeField = new javax.swing.JLabel();
        accountNumberLabel = new javax.swing.JLabel();
        accountNumberField = new javax.swing.JLabel();
        balanceLabel = new javax.swing.JLabel();
        balanceField = new javax.swing.JLabel();
        interestLabel = new javax.swing.JLabel();
        interestField = new javax.swing.JLabel();
        feeLabel = new javax.swing.JLabel();
        feeField = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(9, 2, 5, 5));

        firstNameLabel.setText("First Name:");
        getContentPane().add(firstNameLabel);
        getContentPane().add(firstNameField);

        lastNameLabel.setText("Last Name:");
        getContentPane().add(lastNameLabel);
        getContentPane().add((Component) lastNameField);

        ssnLabel.setText("Social Security Number:");
        getContentPane().add(ssnLabel);
        getContentPane().add((Component) ssnField);

        typeLabel.setText("Account Type:");
        getContentPane().add(typeLabel);
        getContentPane().add((Component) typeField);

        accountNumberLabel.setText("Account Number:");
        getContentPane().add(accountNumberLabel);
        getContentPane().add((Component) accountNumberField);

        balanceLabel.setText("Balance:");
        getContentPane().add(balanceLabel);
        getContentPane().add((Component) balanceField);

        interestLabel.setText("Interest Rate:");
        getContentPane().add(interestLabel);
        getContentPane().add((Component) interestField);

        feeLabel.setText("Transaction Fee:");
        getContentPane().add(feeLabel);
        getContentPane().add(feeField);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton);

        pack();
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	this.dispose();
    }

}
