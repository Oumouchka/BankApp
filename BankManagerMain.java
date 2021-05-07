package BankManagement;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BankManagerMain extends javax.swing.JFrame {

	    private DaoBank bank;
	    private String saveLocation = null;
	    private final DefaultTableModel model;
		private JScrollPane jScrollPane1;
		private JTable accountTable;
		private JButton withdrawButton;
		private JButton removeAccountButton;
		private JButton depositButton;
		private JButton addAccountButton;
		private JPanel contentPanel;
		private JMenuBar menuBar;
		private JMenu fileMenu;
		private JMenuItem exitMenuItem;

        
	    /**
	     * Creates Constructor
	     */
	    public BankManagerMain() {
	        initComponents();
	        setLocationRelativeTo(null);
	        bank = new DaoBank();
	        model = (DefaultTableModel) accountTable.getModel();
	        reloadTable();
	    }

	    
	    private void initComponents() {

	        contentPanel = new javax.swing.JPanel();
	        addAccountButton = new javax.swing.JButton();
	        removeAccountButton = new javax.swing.JButton();
	        depositButton = new javax.swing.JButton();
	        withdrawButton = new javax.swing.JButton();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        accountTable = new javax.swing.JTable();
	        menuBar = new javax.swing.JMenuBar();
	        fileMenu = new javax.swing.JMenu();
	        exitMenuItem = new javax.swing.JMenuItem();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setTitle("Bank Application");

	        addAccountButton.setText("Add Account");
	        addAccountButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                addAccountButtonActionPerformed(evt);
	            }
	        });
	        removeAccountButton.setText("Remove Account");
	        removeAccountButton.setEnabled(false);
	        removeAccountButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                removeAccountButtonActionPerformed(evt);
	            }
	        });
	        
	        depositButton.setText("Deposit");
	        depositButton.setEnabled(false);
	        depositButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                depositButtonActionPerformed(evt);
	            }
	        });

	        withdrawButton.setText("Withdraw");
	        withdrawButton.setEnabled(false);
	        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                withdrawButtonActionPerformed(evt);
	            }
	        });

	        accountTable.setAutoCreateRowSorter(true);
	        accountTable.setModel(new javax.swing.table.DefaultTableModel( new Object [][] { },
	             new String [] { "First Name", "Last Name", "Account Number", "Balance" })
	             {
	                Class[] types = new Class [] {
	                    java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
	                };
	                boolean[] canEdit = new boolean [] {
	                    false, false, false, false
	                };

	                public Class getColumnClass(int columnIndex) {
	                    return types [columnIndex];
	                }

	                public boolean isCellEditable(int rowIndex, int columnIndex) {
	                    return canEdit [columnIndex];
	                }
	            });
	        accountTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        accountTable.getTableHeader().setReorderingAllowed(false);
	        accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                accountTableMouseClicked(evt);
	            }
	        });
	        jScrollPane1.setViewportView(accountTable);
	        if (accountTable.getColumnModel().getColumnCount() > 0) {
	            accountTable.getColumnModel().getColumn(0).setResizable(false);
	            accountTable.getColumnModel().getColumn(1).setResizable(false);
	            accountTable.getColumnModel().getColumn(2).setResizable(false);
	            accountTable.getColumnModel().getColumn(3).setResizable(false);
	        }

	        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
	        contentPanel.setLayout(contentPanelLayout);
	        contentPanelLayout.setHorizontalGroup(
	            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(contentPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
	                    .addGroup(contentPanelLayout.createSequentialGroup()
	                        .addComponent(addAccountButton)
	                        .addGap(18, 18, 18)
	                        .addComponent(removeAccountButton)
	                        .addGap(18, 18, 18)
	                        .addComponent(depositButton)
	                        .addGap(18, 18, 18)
	                        .addComponent(withdrawButton)
	                        .addGap(0, 0, Short.MAX_VALUE)))
	                .addContainerGap())
	        );
	        contentPanelLayout.setVerticalGroup(
	            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(contentPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(addAccountButton)
	                    .addComponent(removeAccountButton)
	                    .addComponent(depositButton)
	                    .addComponent(withdrawButton))
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
	                .addContainerGap())
	        );

	        fileMenu.setText("File");

	       // exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankapp/delete.png"))); // NOI18N
	        exitMenuItem.setText("Exit");
	        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                exitMenuItemActionPerformed(evt);
	            }
	        });
	        fileMenu.add(exitMenuItem);

	        menuBar.add(fileMenu);

	        setJMenuBar(menuBar);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap())
	        );

	        pack();
	    }// 
	    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
	    	this.dispose();
	    }
	    private void addAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {
	    	AccountMenu menu = new AccountMenu(this, true, bank);
	        menu.setVisible(true);
	        if (menu.getCustomer() != null) {
	            addCustomerToTable(menu.getCustomer());
	        }

	    }
	    private void removeAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {
	    	 int result = JOptionPane.showConfirmDialog(this, "Es tu sure?", "Select an Option" , JOptionPane.YES_NO_OPTION);
	         if (result == JOptionPane.OK_OPTION) {
	             int selectedRow = accountTable.getSelectedRow();
	             if (selectedRow >= 0) {
	                 Customer customer = getSelectedCustomer(selectedRow);
	                 if (customer != null) {
	                     bank.closeAccount(customer.getAccount().getAccountNumber());
	                     removeCustomerFromTable(selectedRow);
	                 }
	             }
	         }
	         }
	         private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {
	        	 depositOrWithdraw("deposit");
	         }
	         private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {
	             depositOrWithdraw("withdraw"); 
	         }
	         private void depositOrWithdraw(String action) {
	             int selectedRow = accountTable.getSelectedRow();
	             Customer customer = getSelectedCustomer(selectedRow);
	             if (customer != null) {
	                 javax.swing.JDialog window = null;
	                 if (action.equals("deposit")) {
	                     window = new DepositAllow(this, true, bank, customer);
	                 }
	                 else if (action.equals("withdraw")) {
	                     window = new WithdrawAllow(this, true, bank, customer);
	                 }
	                 if (window != null) {
	                     window.setVisible(true);
	                 }
	                 reloadCustomerRowData(selectedRow, customer.getAccount().getAccountNumber());
	             }
	         }

	         private void accountTableMouseClicked(java.awt.event.MouseEvent evt) {
	        	 setAccountButtonsActive(true);

	             if (evt.getClickCount() == 2) {
	                 int selectedRow = accountTable.getSelectedRow();
	                 Customer customer = getSelectedCustomer(selectedRow);
	                 if (customer != null) {
	                     AccountInfos page = new AccountInfos(this, true, bank, customer);
	                     page.setVisible(true);
	                 }
	             }
	         }
	         private Customer getSelectedCustomer(int selectedRow) {
	             Customer customer = null;
	             if (selectedRow >= 0) {
	                 int accountNumber = (int) accountTable.getValueAt(selectedRow, 2);
	                 customer = bank.getCustomer(accountNumber);
	             }
	             return customer;
	         }

	         private void addCustomerToTable(Customer customer) {
	             model.addRow(new Object[]{});
	             reloadCustomerRowData(model.getRowCount() - 1, customer.getAccount().getAccountNumber());
	         }

	         private void removeCustomerFromTable(int row) {
	             model.removeRow(row);
	         }

	         private void reloadCustomerRowData(int selectedRow, int accountId) {
	             Customer customer = bank.getCustomer(accountId);
	             model.setValueAt(customer.getFirstName(), selectedRow, 0);
	             model.setValueAt(customer.getLastName(), selectedRow, 1);
	             model.setValueAt(customer.getAccount().getAccountNumber(), selectedRow, 2);
	             model.setValueAt(String.format("%.2f", customer.getAccount().getBalance()), selectedRow, 3);
	         }

	         private void reloadTable() {
	             DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
	             // Deletes the rows from the highest index downwards, since deleting 
	             // from index 0 would shift all remaining rows to a lower index
	             for (int i = model.getRowCount() - 1; i >= 0; i--) {
	                 model.removeRow(i); 
	             }
	             for (Customer c : bank.getCustomers()) {
	                 addCustomerToTable(c);
	             }
	         }

	         private void setAccountButtonsActive(boolean active) {
	             depositButton.setEnabled(active);
	             withdrawButton.setEnabled(active);
	             removeAccountButton.setEnabled(active);
	         }

	         public static void main(String args[]) {
	        	 try {
	                 for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                     if ("Nimbus".equals(info.getName())) {
	                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                         break;
	                     }
	                 }
	             } catch (Exception ex) {
	                 java.util.logging.Logger.getLogger(BankManagerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	             }
	        	 /* Create and display the form */
	             java.awt.EventQueue.invokeLater(new Runnable() {
	                 public void run() {
	                     new BankManagerMain().setVisible(true);
	                 }
	             });
	         
	         }

	    

}
