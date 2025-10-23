package com.ui.test.models;

public class CustomerInfo {

	private String gender;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	private String title;
	private String company;
	private Address address;
	private String mobile;
	private CreditCard creditCard;
	
	public String getGender() {
		return gender;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public String getDob() {
		return dob;
	}
	public String getTitle() {
		return title;
	}
	public String getCompany() {
		return company;
	}
	public Address getAddress() {
		return address;
	}
	public String getMobile() {
		return mobile;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
