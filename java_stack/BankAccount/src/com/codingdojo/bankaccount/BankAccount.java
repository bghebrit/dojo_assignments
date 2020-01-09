package com.codingdojo.bankaccount;
import java.util.Random;

public class BankAccount {
	private String accountnumber = "";
	private double checkingbalance = 0.0;
	private double savingsbalance = 0.0;
	private static int numberofaccounts = 0;
	private static double moneystored = 0.0;
	
	public BankAccount() {
		String accountnumber = newAccnt();
		double checkingbalance = 0.0;
		double savingsbalance = 0.0;
		numberofaccounts+=1;
		
	}
	public void setCheckingBalance(double checkingbalance) {
		this.checkingbalance = checkingbalance;
		
	}
	public void setSavingBalance(double savingbalance) {
		this.savingsbalance = savingbalance;
	}
	public double getCheckingBalance() {
		return checkingbalance;
	}
	public double getSavingBalance() {
		return savingsbalance;
	}
	
	private String newAccnt() {
		String number = "0123456789";
		String random = "";
		
		Random r = new Random();
		for(int i=0;i<10;i++) {
			char num = number.charAt(r.nextInt(10));
			random += num;
		}
		return random;
	}
	
	public void depositMoney(String type , double depositAmount) {
		if(type == "checking") {
			setCheckingBalance(getCheckingBalance()+ depositAmount);
			moneystored += depositAmount;
		}
		else if(type == "savings") {
			setSavingBalance(getSavingBalance()+ depositAmount);
			moneystored += depositAmount;
		}
	}
	
	public void withdrawMoney(String type , double withdrawAmount) {
		
		if(type == "checking") {
			if (getCheckingBalance() < withdrawAmount) {
				System.out.println("insufficient money");
			}
			else {
			setCheckingBalance(getCheckingBalance() - withdrawAmount);
			moneystored -= withdrawAmount;
			}
		}
		if (type == "saving") {
			if (getSavingBalance() < withdrawAmount) { 
				System.out.println("insufficient money");
			}
			else {
			setSavingBalance(getSavingBalance()- withdrawAmount);
			moneystored -= withdrawAmount;	
			}
		}
	}	
	public double myBalance() {
		double totalBalance = checkingbalance + savingsbalance;
		System.out.println(totalBalance);
		return totalBalance;
	}
}