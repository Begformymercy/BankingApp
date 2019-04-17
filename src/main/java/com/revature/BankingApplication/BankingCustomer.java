package com.revature.BankingApplication;

import java.util.Scanner;

public class BankingCustomer {

	String userName;
	String passwordString;
	String input ="";
	Scanner scan = new Scanner(System.in);
	Boolean loggedIn = false;//account is logged in, shouldn't need to create a new account
	int result;//int casting variable
	
	public BankingCustomer(String customername, String customerpass) {
		this.userName=customername;
		this.passwordString=customername;
	}
	
	public static Double tryDouble(String str) {
		try {
			Double newAmount = Double.parseDouble(str);
			return newAmount;
		}catch (Exception e) {
			System.out.println("Didn't make a correct selection");	
		}
		return null;
	}
	
	public void menu() {
		
		System.out.println("Please enter your username:");
		input = scan.nextLine();
		String userName = input;
		System.out.println("Please enter your password:");
		input = scan.nextLine();
		String userPass = input;
		
		if(userName.equals("") && userPass.equals("")) {
			loggedIn = true;//If account cannot be found on database, then create one
		}
		System.out.println("Sorry, could not locate an exisisting account, create an account:");
		
		
		//Open account, check balance, deposit, withdrawal, close account
		if(!loggedIn) {
			System.out.println("To open an account enter 1");
		}
		
		if(loggedIn) {
			System.out.println("To check balance enter 2");				
			System.out.println("To make a deposit enter 3");
			System.out.println("To make a withdrawal enter 4");
			System.out.println("To close your account enter 5");
		}
		input = scan.nextLine();
		try {
			result = Integer.parseInt(input);
		
			switch (result) { 
	        case 1: 
				System.out.println("Creates account");
				System.out.println("So you  have chosen a user name and password which are: "+userName+" "+userPass);
				System.out.println("Your account number will be: ");//grab from database query
				System.out.println("Your account balance is currently 0 would you like to make a deposit? ");
				input = scan.nextLine();
				if(input.toLowerCase().equals("yes")) {
					if(tryDouble(input) != null) {
		        		//change balance
		        	}
					else {
						System.out.println("Didn't enter a Double");
						break;
					}
					System.out.println("You made a deposit ");
				}
				System.out.println("Would you like to make this a joint bank account now? ");
				input = scan.nextLine();
				if(input.toLowerCase().equals("yes")) {
					System.out.println("Please enter your joint username:");
					input = scan.nextLine();
					String jointUserName = input;
					System.out.println("Please enter your joint password:");
					input = scan.nextLine();
					String jointPass = input;
				}
	            break; 
	        case 2:  
				System.out.println("Your balance is blah");
	            break; 
	        case 3: 
				System.out.println("Enter ammount to deposit");
				if(tryDouble(input) != null) {
	        		//change balance
	        	}
				else {
					System.out.println("Didn't enter a Double");
					break;
				}
	            break; 
	        case 4:  
				System.out.println("Enter ammount to withdraw");
				if(tryDouble(input) != null) {
	        		//change balance
	        	}
				else {
					System.out.println("Didn't enter a Double");
					break;
				}
	            break; 
	        case 5:
				System.out.println("Closed account, you are now broke");  
	            break; 
	        default: 
	        	System.out.println("You didn't make a correct selection."); 
	            break; 
	        }
		}catch (Exception e) {
			System.out.println("is it really so hard to type an integer?");
		}
	
	}

}
