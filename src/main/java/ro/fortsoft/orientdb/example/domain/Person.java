package ro.fortsoft.orientdb.example.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Decebal Suiu
 */
public class Person {

    private String firstname;
    private String lastname;
    private int age;

    private Address defaultAddress;
    private List<Address> addresses = new ArrayList<Address>();

    private Account account;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Address getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Address defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
    public String toString() {
    	/*
    	System.out.println("... " + firstname); // ?? it's null
    	System.out.println("+++ " + getFirstname()); // it's notnull
    	*/
    	
        StringBuilder builder = new StringBuilder();
        
        builder.append("Person[");
        builder.append("firstname=").append(getFirstname()).append(",");
        builder.append("lastname=").append(getLastname()).append(",");
        builder.append("defaultAddress=").append(getDefaultAddress()).append(",");
        builder.append("addresses=").append(getAddresses()).append(",");
        builder.append("age=").append(getAge()).append(",");
        builder.append("account=").append(getAccount());
        builder.append("]");
        
        return builder.toString();
    }
    
}
