package BankManagement;

import java.io.Serializable;

public abstract class Account  implements Serializable{
	    private double balance = 0;
	    private int accountNumber;
	    
	    Account(int accountNumber){
	        this.accountNumber = accountNumber;
	    }
	    
	    //Checking class
	    /*public class Checking extends Account{
	        
	        Checking(int accountNumber, double initialDeposit){
	            super(accountNumber);
	            this.setBalance(initialDeposit);
	        }

	        @Override
	        public AccountType getAccountType() {
	            return AccountType.Checking;
	        }
	    }
	    
	    //Saving Class
	    
	    public class Savings extends Account{
	        
	        Savings(int accountNumber, double initialDeposit){
	            super(accountNumber);
	            this.setBalance(initialDeposit);
	        }
	       
	        @Override
	        public AccountType getAccountType() {
	            return AccountType.Savings;
	        }
	    }*/
	    
	    	
	      
	    public abstract AccountType getAccountType();
	    
	    @Override
	    public String toString(){
	        return "Account Type: " + getAccountType().name() + " Account\n" +
	                "Account Number: " + this.getAccountNumber() + "\n" +
	                "Balance: " + this.getBalance() + "\n";
	    }
	    /**
	     * Getter and Setter
	     */
	    public double getBalance() {
	        return balance;
	    }

	    
	    public final void setBalance(double balance) {
	        this.balance = balance;
	    }

	    public int getAccountNumber() {
	        return accountNumber;
	    }
	}




