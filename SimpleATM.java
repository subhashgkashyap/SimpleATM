import java.util.*;

public class SimpleATM {
	static Scanner sc = new Scanner(System.in);
	
	public double balance = 1000.0;
	public int pin = 1234;
	
	public void getPIN() {
		int pin_no = sc.nextInt();
		if (pin_no == pin) {
			MainMenu();
		}
		else {
			System.out.println("Please enter vaild PIN");
			getPIN();
		}
	}
	
	public void getDetails() {
		System.out.print("Enter account number: ");
		String acc_no = sc.next();
		
		System.out.print("Enter your PIN Number: ");
		getPIN();
	}
	
	public void MainMenu() {
		int choice;
		
		System.out.println("MAIN MENU");
		System.out.println("1 ----- Check Balance");
		System.out.println("2 ----- Cash Withdrawal");
		System.out.println("3 ----- Cash Deposit");
		System.out.println("4 ----- PIN Upgradation");
		
		System.out.print("Enter your choice: ");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1: checkBalance(); 
		break;
		case 2: cashWithdrawal(); 
		break;
		case 3: cashDeposit(); 
		break;
		case 4: PINUpgradation(); 
		break;
		}
		
	}
	
	public void PINUpgradation() {
		System.out.print("Enter existing PIN: ");
		int entered_pin = sc.nextInt();
		if (entered_pin == pin) {
			System.out.print("Enter new PIN: ");
			pin = sc.nextInt();
		}
		else {
			System.out.println("Please enter vaild PIN.");
		}
		MainMenu();
	}

	public void cashDeposit() {
		System.out.print("Enter amount to deposit: ");
		float deposit_amt = sc.nextFloat();
		balance = balance + deposit_amt;
		MainMenu();
	}

	public void cashWithdrawal() {
		System.out.print("Enter amount for withdrawal: ");
		float withdrawal_amt = sc.nextFloat();
		if (withdrawal_amt < balance) {
			balance = balance - withdrawal_amt;
		}
		else {
			System.out.println("Insufficient balance.");
		}
		MainMenu();
	}

	public void checkBalance() {
		System.out.println("Available balance: " + balance);
		MainMenu();
	}

	public static void main(String[] args) {
		ATM atm = new ATM();
						
		atm.getDetails();
		
		sc.close();
	}

}
