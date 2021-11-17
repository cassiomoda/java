package model.entities;

import model.exceptions.MyException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		super();
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}


	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) throws MyException {
		if (amount < 1.00) {
			throw new MyException("The deposit amount needs to be positive");
		}
		
		balance += amount;
	}
	
	public void withdraw(Double amount) throws MyException {
		if (amount < 1.00) {
			throw new MyException("The withdraw amount needs to be positive");
		}
		
		if (amount > withdrawLimit) {
			throw new MyException("Withdraw limit exceded. The withdraw limit is: $" + String.format("%.2f", withdrawLimit));
		}
		
		if (amount > balance) {
			throw new MyException("Withdraw amount exceds your balance value. Actual balance: $" + String.format("%.2f", balance));
		}
		
		balance -= amount;
	}
}
