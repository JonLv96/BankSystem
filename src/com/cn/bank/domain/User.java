package com.cn.bank.domain;

public class User {

	private String userName;
	private String IDCard;
	private String userCounter;
	private String userPassword;
	private Money money;

	
	@Override
	public String toString() {
		return "user [userName=" + userName + ", IDCard=" + IDCard + ", userCounter=" + userCounter + ", userPassword="
				+ userPassword + ", money=" + money + "]";
	}
	
	//�޲ι��캯��
	public User() {
		super();
	}

	//����ֻ���û���������Ĺ��췽��
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
		
	//ȫ���������캯��
	public User(String userName, String iDCard, String userCounter, String userPassword, Money money) {
		super();
		this.userName = userName;
		IDCard = iDCard;
		this.userCounter = userCounter;
		this.userPassword = userPassword;
		this.money = money;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getUserCounter() {
		return userCounter;
	}
	public void setUserCounter(String userCounter) {
		this.userCounter = userCounter;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Money getMoney() {
		return money;
	}
	public void setMoney(Money money) {
		this.money = money;
	}
	
}
