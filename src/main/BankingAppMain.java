package BankingApp;
import java.util.*;//import scanner
import javax.xml.stream.events.StartDocument;
import BankingApp.BankingAccount;

public class BankingAppMain {
	

	public Double tryDouble(String str) {
		try {
			Double newAmount = Double.parseDouble(str);
			return newAmount;
		}catch (Exception e) {
			System.out.println("Didn't make a correct selection");	
		}
		return null;
	}
	
	public static void main(String[] args) {
		String employeeName = "employee";//not a customer answer, else employee is the customer for this transaction
		String employeePass = "password";//employee password
		Boolean admin = false;//employee verifies they are an administrator or not, after selection, logs actions
		Boolean runApplication = true;
		Boolean loggedIn = false;//account is logged in, shouldn't need to create a new account
		String input ="";
		int accountCounter = 0;//Becomes account ID
		Scanner scan = new Scanner(System.in);
		int result;//int casting variable
		double localBalance;
		
		//Store applications locally that would be populated for an employee from a database
		ArrayList<BankingAccount> applicationsAccounts = new ArrayList<BankingAccount>();
		
		//Start a loop
		do {
			/**Determine employee or customer
			 * 
			 * if employee, enter a password, look up account IDs, etc.
			 * 
			 * if customer, open account, close account, or create account
			 */
			System.out.println("Welcome to Banking R US");
			System.out.println("Are you a Customer?: yes / no");		
			//take input
			input = scan.nextLine();
			//Employee
			if(input.toLowerCase().equals("no")) {
				System.out.println("Please enter employee username:");
				input = scan.nextLine();
				if(input.equals(employeeName)) {
					System.out.println("Please enter employee password:");
					input = scan.nextLine();
					if(input.equals(employeePass)) {
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
								System.out.println("Do you want to run as an admin?");
								input = scan.nextLine();
								if(input.toLowerCase().equals("yes")) {
									admin = true;
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
										int someNumber = Integer.parseInt(input);
										
										switch (someNumber) { 
								        case 1: 
											System.out.println("Changed Primary User Password");
								            break; 
								        case 2: 
											System.out.println("Changed Joint User Password");
								            break;
								        case 3: 
											System.out.println("Please enter a Double");
								        	input = scan.nextLine();
								        	if(tryDouble(input) != null) {
								        		//change balance
								        	}
											System.out.println("Didn't enter a Double");
								            break;
								        case 4: 
											System.out.println("Enter the account ID you wish to transfer from: ");
											//input = scan.nextLine();
											System.out.println("Enter the ammount you wish to withdrawal: ");
											input = scan.nextLine();
											System.out.println("Please enter a Double");
								        	input = scan.nextLine();
								        	if(tryDouble(input) != null) {
								        		//change balance
								        	}
											System.out.println("Didn't enter a Double");	
											System.out.println("Enter the account ID you wish to transfer to: ");
											//input = scan.nextLine();
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
			}else if(input.toLowerCase().equals("yes")){//Customer
				System.out.println("Please enter your username:");
				input = scan.nextLine();
				String userName = input;
				System.out.println("Please enter your password:");
				input = scan.nextLine();
				String userPass = input;
				
				/**
				//Create an account object and either populate it from the database or, start creating one.
				BankingAccount myAccount = new BankingAccount(accountID, primaryUserName, jointUsername, 
				primaryPass, jointPass, balance);
				*/
				
				/**
				 * 
				 * Query database to locate account information and create an object
				 * 
				 */
				if(userName.equals("") && userPass.equals("")) {
					loggedIn = true;//If account cannot be found on database, then create one
				}
				System.out.println("Sorry, could not locate an exisisting account, create an account:");
				
				
				//Open account, check balance, deposit, withdrawal, close account
				if(!loggedIn) {
					System.out.println("To open an account enter 1");
				}
				System.out.println("To check balance enter 2");				
				System.out.println("To make a deposit enter 3");
				System.out.println("To make a withdrawal enter 4");
				if(loggedIn) {
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
							
						}
			            break; 
			        case 2:  
						System.out.println("Your balance is blah");
			            break; 
			        case 3: 
						System.out.println("Enter ammount to deposit");
			            break; 
			        case 4:  
						System.out.println("Enter ammount to withdraw");
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
			//Logs should be done in account or here?

			System.out.println("Are you finished with the Banking App?");	
			input = scan.nextLine();
			if(input.equals("yes"))
				runApplication = false;
		}while(runApplication);
		scan.close();
	}

}
