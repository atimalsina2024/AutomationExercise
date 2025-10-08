package com.test.models;

public class CreditCard {
	
	private String nameOnCard;
	private String number;
	private String cvc;
	private ExpirationDate date;

	public String getNumber() {
		return number;
	}
	public String getCvc() {
		return cvc;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public ExpirationDate getDate() {
		return date;
	}
	public void setDate(ExpirationDate date) {
		this.date = date;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

}
