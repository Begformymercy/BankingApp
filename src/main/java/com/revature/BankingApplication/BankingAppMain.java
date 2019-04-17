package com.revature.BankingApplication;
import java.util.*;//import scanner

public class BankingAppMain {
	
	static String employeeName = "employee";//not a customer answer, else employee is the customer for this transaction
	static String employeePass = "password";//employee password
	static Boolean admin = false;//employee verifies they are an administrator or not, after selection, logs actions
	static Boolean runApplication = true;
	static Boolean loggedIn = false;//account is logged in, shouldn't need to create a new account
	static String input ="";
	static int accountCounter = 0;//Becomes account ID
	static Scanner scan = new Scanner(System.in);
	static int result;//int casting variable
	static double localBalance;
	
	public static void main(String[] args) {
		//Store applications locally that would be populated for an employee from a database
		ArrayList<BankingAccount> applicationsAccounts = new ArrayList<BankingAccount>();
		do {
			System.out.println("Welcome to Banking R US");
			System.out.println("Are you a Customer?: yes / no");	
			input = scan.nextLine();
			if(input.toLowerCase().equals("no")) {//Employee
				BankingEmployee BE = new BankingEmployee("employee","password");
				BE.menu();	
			}else if(input.toLowerCase().equals("yes")){//Customer
				
				BankingCustomer BC = new BankingCustomer("customer","password");
				BC.menu();		
			}
			//Logs should be done in account or here?			
			System.out.println("Are you finished with the Banking App?");	
			input = scan.nextLine();
			if(input.equals("yes"))
				runApplication = false;
		}while(runApplication);
		scan.close();
	}

}
