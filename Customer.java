package BankManagement;

import java.awt.List;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer implements Serializable{
    private final String firstName;
    private final String lastName;
    private final String ssn;
    private final Account account;

    Customer(String firstName, String lastName, String ssn, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.account = account;
    }
    
    public Customer() {
		this.firstName = "";
		this.lastName = "";
		this.ssn = "";
		// TODO Auto-generated constructor stub
		this.account = null;
	}

	@Override
    public String toString(){
        return "\nCustomer Information\n" +
                "First Name: " + getFirstName() + "\n" + 
                "Last Name: " + getLastName() +  "\n" + 
                "SSN: " + getSsn() +  "\n" + 
                account;
    }
    public String basicInfo(){
        return " Account Number: " + account.getAccountNumber() + " - Name: " + getFirstName() + " " + getLastName();
    }
    
    Account getAccount(){
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void findById(int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(int id, boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
	}
    
}


    

