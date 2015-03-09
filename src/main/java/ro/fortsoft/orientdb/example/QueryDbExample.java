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
package ro.fortsoft.orientdb.example;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.fortsoft.orientdb.example.domain.Account;
import ro.fortsoft.orientdb.example.domain.Address;
import ro.fortsoft.orientdb.example.domain.Person;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

/**
 * @author Decebal Suiu
 */
public class QueryDbExample {

	private static Logger log = LoggerFactory.getLogger(QueryDbExample.class);

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        OObjectDatabaseTx db = getDatabase();

        long personCount = db.countClass(Person.class);
        if (personCount == 0) {
        	createPerson(db);
        }
        queryPersons(db);

        db.close();

        time = System.currentTimeMillis() - time;
        log.debug("Executed in {} ms", time);
    }

	private static OObjectDatabaseTx getDatabase() {
		// create a database in memory
//        OObjectDatabaseTx db = new OObjectDatabaseTx("memory:data").create();

        // create a database on disk
        OObjectDatabaseTx db = new OObjectDatabaseTx("local:data");
        if (db.exists()) {
        	db = new OObjectDatabaseTx("local:data").open("admin", "admin");
        } else {
        	db.create();
        }

        // register all classes from a package
        db.getEntityManager().registerEntityClasses(Person.class.getPackage().getName());

        // register class by class
//        db.getEntityManager().registerEntityClass(Person.class);
//        db.getEntityManager().registerEntityClass(Address.class);
//        db.getEntityManager().registerEntityClass(Account.class);

		return db;
	}

	private static void createPerson(OObjectDatabaseTx db) {
		log.debug("Create person");

		// create an object
        Person person = new Person();
//        Person person = db.newInstance(Person.class);
        person.setFirstName("Decebal");
        person.setLastName("Suiu");
//        person.setAge(23);

        Address address = new Address();
//        Address address = db.newInstance(Address.class);
        address.setStreet("London Bridge");
        address.setPostcode("123");
        person.getAddresses().add(address);
        person.setDefaultAddress(address);

        Account account = new Account();
//        Account account = db.newInstance(Account.class);
        account.setPassword("decebal");
        account.setUsername("decebals");
        person.setAccount(account);

        // save object in database
        log.debug("Save person in database");
        db.save(person);
	}

	private static void queryPersons(OObjectDatabaseTx db) {
		// make some queries
		log.debug("Get all persons");
        for (Person p : db.browseClass(Person.class)) {
            log.debug(p.toString());
        }

        log.debug("Query persons by firstname");
        String sql = "select * from Person where firstname like 'D%'";
        log.debug("sql = {}", sql);
        List<Person> persons = db.query(new OSQLSynchQuery<Person>(sql));
        for (Person p : persons) {
            log.debug(p.toString());
        }

        log.debug("Query persons by lastname");
        sql = "select * from Person where lastname like 'S%'";
        log.debug("sql = {}", sql);
        persons = db.query(new OSQLSynchQuery<Person>(sql));
        for (Person p : persons) {
            log.debug(p.toString());
        }
	}

}
