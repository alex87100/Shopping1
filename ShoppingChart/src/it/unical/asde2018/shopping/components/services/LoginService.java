package it.unical.asde2018.shopping.components.services;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import it.unical.asde2018.shopping.model.Account;

@Service
public class LoginService {
	
	public Set<Account> registeredUsers = new HashSet<>();
	
	@PostConstruct
	public void init() {
		registeredUsers.add(new Account("Ciccio","Pasticcio","pasticcio@tiscali.it","Via del Pasticcio, 8","3333456367","past", "123"));
		registeredUsers.add(new Account("Jack","Sparrow","sparrow@tiscali.it","Via del Pirata, 10","3333335857","jack", "123"));
		registeredUsers.add(new Account("alex", "123"));		
	}

	public boolean login(String username, String password) {
		return registeredUsers.contains(new Account(username, password));
	}
	
	public String getName(String username) {
		String name=null;
		for (Account account : registeredUsers) {
			if(account.getUsername().equals(username)) 
				name = account.getName();			
		}
		return name;
	}
	
	public void setName(String username,String name) {
		for (Account account : registeredUsers) {
			if(account.getUsername().equals(username)) 
				account.setName(name);			
		}
	}
	
	public String getSurname(String username) {
		String surname=null;
		for (Account account : registeredUsers) {
			if(account.getUsername().equals(username)) 
				surname = account.getSurname();			
		}
		return surname;
	}
	
	public String getEmail(String username) {
		String email=null;
		for (Account account : registeredUsers) {
			if(account.getUsername().equals(username)) 
				email = account.getEmail();			
		}
		return email;
	}
	
	public String getAddress(String username) {
		String address=null;
		for (Account account : registeredUsers) {
			if(account.getUsername().equals(username)) 
				address = account.getAddress();			
		}
		return address;
	}
	
	public String getPhone(String username) {
		String phone=null;
		for (Account account : registeredUsers) {
			if(account.getUsername().equals(username)) 
				phone = account.getEmail();			
		}
		return phone;
	}

}