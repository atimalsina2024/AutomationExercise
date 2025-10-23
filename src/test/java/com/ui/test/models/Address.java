package com.ui.test.models;

public class Address {
	
	private String street;
	private String apt;
	private String city;
	private String state;
	private String Zip;
	private String country;
	
	public String getStreet() {
		return street;
	}
	public String getApt() {
		return apt;
	}
	public String getCity() {
		return city;
	}
	public String getZip() {
		return Zip;
	}
	public String getCountry() {
		return country;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setApt(String apt) {
		this.apt = apt;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setZip(String zip) {
		Zip = zip;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
