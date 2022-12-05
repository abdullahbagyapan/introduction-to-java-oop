package bankApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
	private String name;
	private int money , password , incorrectPassword=0;
	private static int totalBankAccount = 0;
	private List<String> accountHistory = new ArrayList<String>(); 
	private static Map<String,Integer> bankData = new HashMap<>();
	
	
	public Bank(String name , Integer password) {
		this.name = name;
		this.password = password;
		this.money = 0;
		totalBankAccount++;
		this.accountHistory.add("Bank account created");
		bankData.put(this.name,this.money);
		
	}
	
	public void depositeMoney(int amount) {
		if (checkIncorrectPw()) {
			bankData.replace(this.name,bankData.get(this.name) + amount);
			this.accountHistory.add("Deposited "+amount+" $");
			System.out.println("Process completed");
		}
		else {
			System.out.println("Declined your process");
			checkProcess();
		}
	}
	
	public void withdrawMoney(int amount) {
		if (checkIncorrectPw()) {
			if (bankData.get(this.name) >= amount) {
				bankData.replace(this.name,bankData.get(this.name) - amount);
				this.accountHistory.add("Withdrawed "+amount+" $");
				System.out.println("Process completed");
			}
			else {
				System.out.println("You have not enough money");
			}
		}
		else {
			System.out.println("Declined your process");
			checkProcess();
		}
	}
	
	public void transferMoney(String name,int amount) {
		if (checkIncorrectPw()) {
			if (bankData.get(this.name) >= amount) {
				bankData.replace(name,bankData.get(name) + amount);
				bankData.replace(this.name,bankData.get(this.name) - amount);
				this.accountHistory.add("Transfered "+amount+" $");
				System.out.println("Process completed");
			}
		}
		else {
			System.out.println("Declined your process");
			checkProcess();
		}
	}
	
	public void viewAccountDetails(int password) {
		if (checkPassword(password) && checkIncorrectPw()) {
			for (String process : accountHistory) {
				System.out.println(process);
			}			
		}
		else {
			System.out.println("Declined your process");
			checkProcess();
		}
	}
	
	private boolean checkPassword(int password) {
		if (this.password == password) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean checkIncorrectPw() {
		if (this.incorrectPassword >= 3) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private void checkProcess() {
		if (this.incorrectPassword >= 3) {
			System.out.println("Your card has been seized");
			System.out.println("Please reset your password");
		}
		else {
			this.incorrectPassword++;
		}
	}
	
	public void resetPassword(int oldPassword , int newPassword) {
		if (checkPassword(oldPassword)) {
			this.password = newPassword;
			accountHistory.add("Changed password");
			System.out.println("Your password has changed");
		}
		else {
			System.out.println("Incorret password.Try again");
		}
	}
	
	public void showTotalAccountNum() {
		System.out.println(totalBankAccount);
	}
	
	
	
}
