/*
 * Copyright (C) 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.fortsoft.orientdb.example.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Decebal Suiu
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;

    private Address defaultAddress;
    private List<Address> addresses = new ArrayList<Address>();

    private Account account;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    	System.out.println("... " + firstName); // ?? it's null
    	System.out.println("+++ " + getFirstName()); // it's notnull
    	*/

        StringBuilder builder = new StringBuilder();

        builder.append("Person[");
        builder.append("firstName=").append(getFirstName()).append(",");
        builder.append("lastName=").append(getLastName()).append(",");
        builder.append("defaultAddress=").append(getDefaultAddress()).append(",");
        builder.append("addresses=").append(getAddresses()).append(",");
        builder.append("age=").append(getAge()).append(",");
        builder.append("account=").append(getAccount());
        builder.append("]");

        return builder.toString();
    }

}
