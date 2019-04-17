package com.revature.BankingApplication;

import java.util.Scanner;

public class BankingEmployee {
	public String EmployeeNameString;
	public String EmployeePassString;
	public BankingAccount[] BAs;
	
	String input ="";
	Scanner scan = new Scanner(System.in);
	String employeeName = "employee";//not a customer answer, else employee is the customer for this transaction
	String employeePass = "password";//employee password
	Boolean admin = false;//employee verifies they are an administrator or not, after selection, logs actions
	int result;//int casting variable
	
	public BankingEmployee(String employeeName, String employeePass) {
		this.EmployeeNameString=employeeName;
		this.EmployeePassString=employeePass;
	}
	
	public Boolean approveAccounts() {
		return null;		
	}
	
	
	public static Integer tryInteger(String str) {
		try {
			Integer newAmount = Integer.parseInt(str);
			return newAmount;
		}catch (Exception e) {
			System.out.println("Didn't make a correct selection");	
		}
		return null;
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
		System.out.println("Please enter employee username:");
		input = scan.nextLine();
		if(input.equals(employeeName)) {
			System.out.println("Please enter employee password:");
			input = scan.nextLine();
			if(input.equals(employeePass)) {
				//admin check on log in
				if(!admin)
					admin=true;
				System.out.println("To approve or deny accounts press 1");
				System.out.println("To edit accounts enter 2");
				
				input = scan.nextLine();
				try {
					result = Integer.parseInt(input);
					
					switch (result) { 
			        case 1: 
						System.out.println("You are going to approve or deny accounts");
						System.out.println("To approve an account enter 1");
						System.out.println("To deny an account enter 2");

						input = scan.nextLine();
						try {
							int someNumber = Integer.parseInt(input);
							
							switch (someNumber) { 
					        case 1: 
								System.out.println("Account Approved");
								//approve account BankingAccout.approveAccount();
					            break; 
					        case 2: 
								System.out.println("Account Denied");	
								//deny account if(BankingAccout.approveAccount() == false);
					            break;
					        default: 
					            break; //user didn't enter 1 / 2
					        }
						}catch (Exception e) {
							System.out.println("Didn't make a correct selection");	
						}	
			            break; 
			        case 2: 
						System.out.println("You are going to edit an account");	//edit accounts						
						if(admin) {
							//log account changes made by employee as an admin
							/**
							 * 
							 * Load up an array* of BankingAccounts, and use a nested Switch statement to pan through pages or select index
							 */

							System.out.println("Enter the account ID you wish to Edit: ");
							//input = scan.nextLine();
							
							System.out.println("Change Primary User Password : 1");
							System.out.println("Change Joint User Password : 2");
							System.out.println("Change Account Balance : 3");
							System.out.println("Transfer Funds Between 2 accounts : 4");
	
							input = scan.nextLine();
							try {
								if(tryInteger(input) != null) {
					        		//change balance
					        	}
								else {
									System.out.println("Didn't enter an Integer");
									break;
								}
								int someNumber = Integer.parseInt(input);
								switch (someNumber) { 
						        case 1: //Change Primary User Password 
									System.out.println("Changed Primary User Password");
						            break; 
						        case 2: //Change Joint User Password
									System.out.println("Changed Joint User Password");
						            break;
						        case 3: //Change Account Balance
									System.out.println("Please enter a Double");
						        	input = scan.nextLine();
						        	if(tryDouble(input) != null) {
						        		//change balance

										System.out.println("Here is your Balance:");
						        	}
									System.out.println("Didn't enter a Double");
						            break;
						        case 4: //Transfer Funds Between 2 accounts
									System.out.println("Enter the account ID you wish to transfer from: ");
									input = scan.nextLine();
									System.out.println("Please enter an Integer");
									if(tryInteger(input) != null) {
						        		//change balance
						        	}
									else {
										System.out.println("Didn't enter an Integer");
										break;
									}
									System.out.println("Enter the ammount you wish to withdrawal: ");
									input = scan.nextLine();
						        	if(tryDouble(input) != null) {
						        		//change balance
						        	}
									System.out.println("Please enter a Double");
						        	input = scan.nextLine();
						        	if(tryDouble(input) != null) {
						        		//change balance
						        	}
									else {
										System.out.println("Didn't enter a Double");
										break;
									}
									System.out.println("Enter the account ID you wish to transfer to: ");
									input = scan.nextLine();
									System.out.println("Please enter an Integer");
									if(tryInteger(input) != null) {
						        		//change balance
						        	}
									else {
										System.out.println("Didn't enter an Integer");
										break;
									}
						            break;
						        default: 
						            break; //user didn't enter any correct selection
						        }
							}catch (Exception e) {
								System.out.println("Didn't make a correct selection");	
							}
						}
						else{
							System.out.println("Sorry you are not an admin, you cannot edit");
						}
						//deny account
			            break;
			        default: 
			            break; //user didn't enter 1 / 2
			        }
				}catch(Exception e) {
					
				}					
			}else{
				//loop out
				System.out.println("Sorry that is not the correct employee password");	
			}
		}else{
			//loop out
			System.out.println("Sorry that is not the correct employee username");	
		}
	}

}
