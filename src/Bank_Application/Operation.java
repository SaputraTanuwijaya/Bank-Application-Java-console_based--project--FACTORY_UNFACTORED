package Bank_Application;
import java.util.Scanner;

import model.User;

public class Operation 
{
	private static Process bankprocess = new Process();
	private static Scanner scan = new Scanner(System.in);
//	public BankProxy bank = new BankProxy();
	
	public static void bankinfo() 
	{
        System.out.println(" ----------------------------------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.println(" ***Banking System Application***");
	    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.print(" 1. Check Balance\n"
	    		+ "2. Deposit the amount\n"
	    		+ "3. Withdraw the amount\n"
	    		+ "4. Transfer\n"
	    		+ "5. Log out\n"
	    		+ "ENTER YOUR CHOICE :: "); 
	    int key = 0;
		try {
			key = scan.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.nextLine();
		}
	    operation(key);
	}
	
	public static void menu () {
		int key = 0;
		
		do {
			System.out.println(" ----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(" ***Banking System Application***");
			System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.print(" 1. Login\n"
					+ " 2. Register\n"
					+ " 3. Exit\n"
					+ "ENTER YOUR CHOICE :: ");
			try {
				key = scan.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				scan.nextLine();
			}
			
			switch (key) {
			case 1:
				bankprocess.login();
				break;
			case 2:
				bankprocess.register();
				break;
			case 3:
				System.out.println("THANK YOU FOR USING OUR SERVICE. SEE YOU NEXT TIME!");
				break;
			default:
				menu();
				break;
			}
		} while (key != 3);
		
	}
	
	public static void operation(int key) {
		 switch (key) 
		 {
			case 1:
			    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			    bankprocess.checkbalance();
				System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println();
				waitEnter();
				bankinfo();
				break;
			case 2:
			    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
				bankprocess.deposit();
				System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println();
				waitEnter();
				bankinfo();
				break;
			case 3:
			    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
				bankprocess.withdraw();
			    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			    System.out.println();
				waitEnter();
				bankinfo();
				break;
			case 4:
			    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
				bankprocess.transfer();
				System.out.println();
				System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
				waitEnter();
				bankinfo();
				break;
			case 5:
				System.out.println("THANKS FOR USING OUT BANK APPLICATION");
				bankprocess.currentUser = null;
				menu();
				break;
			default:
				bankinfo();
				break;
			}
	}
	
	public static void waitEnter() {
		System.out.println("PRESS ENTER TO CONTINUE ::");
		scan.nextLine();
	}
}