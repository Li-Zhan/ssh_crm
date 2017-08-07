package cn.lynu.model;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int did;
	
	private String userName;
	
	private String password;
	
	private String address;
	
	private Set<Visit> setVisit=new HashSet<>();
	
	private Set<Customer> setCustomer=new HashSet<>();
	
	

	public Set<Customer> getSetCustomer() {
		return setCustomer;
	}

	public void setSetCustomer(Set<Customer> setCustomer) {
		this.setCustomer = setCustomer;
	}

	public Set<Visit> getSetVisit() {
		return setVisit;
	}

	public void setSetVisit(Set<Visit> setVisit) {
		this.setVisit = setVisit;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
