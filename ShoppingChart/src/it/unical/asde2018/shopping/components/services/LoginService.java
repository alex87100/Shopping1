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
		registeredUsers.add(new Account("Ciccio", "Pasticcio", "pasticcio@tiscali.it", "Via del Pasticcio, 8",
				"3333456367", "past", "123"));
		registeredUsers.add(new Account("Jack", "Sparrow", "sparrow@tiscali.it", "Via del Pirata, 10", "3333335857",
				"jack", "123"));
		registeredUsers.add(new Account("alex", "123"));
	}

	public boolean login(String username, String password) {
		return registeredUsers.contains(new Account(username, password));
	}

	public boolean exist(String username) {
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				return true;
		}
		return false;
	}

	public void addAccount(String name, String surname, String email, String address, String phone, String username,
			String password) {
		registeredUsers.add(new Account(name, surname, email, address, phone, username, password));
	}

	public Account getAccount(String username) {
		Account account = null;
		for (Account a : registeredUsers) {
			if (a.getUsername().equals(username))
				account = a;
		}
		return account;
	}

	public String getName(String username) {
		String name = null;
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				name = account.getName();
		}
		return name;
	}

	public void setName(String username, String name) {
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				account.setName(name);
		}
	}

	public String getSurname(String username) {
		String surname = null;
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				surname = account.getSurname();
		}
		return surname;
	}

	public void setSurname(String username, String surname) {
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				account.setSurname(surname);
		}
	}

	public String getEmail(String username) {
		String email = null;
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				email = account.getEmail();
		}
		return email;
	}

	public void setEmail(String username, String email) {
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				account.setEmail(email);
		}
	}

	public String getAddress(String username) {
		String address = null;
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				address = account.getAddress();
		}
		return address;
	}

	public void setAddress(String username, String address) {
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				account.setAddress(address);
		}
	}

	public String getPhone(String username) {
		String phone = null;
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				phone = account.getEmail();
		}
		return phone;
	}

	public void setPhone(String username, String phone) {
		for (Account account : registeredUsers) {
			if (account.getUsername().equals(username))
				account.setPhone(phone);
		}
	}

}