package atmInterface;

import atm.ATM;
//Implementaion Class of Interface Abstract Methods
//Perform a Tasks and Written Logic 
public class ATMImplmentation implements ATMInterface{

	
	public void displayMenu() {
		System.out.println("1: Check Balance");
		System.out.println("2: Deposite");
		System.out.println("3: Withdraw");
		System.out.println("4: Change Pin");
		System.out.println("5: Exit");

	}
	public void deposit(float Ammount,ATM a) {
		float bal=a.getBalance();
		bal+=Ammount;
		a.setBalance(bal);
		
	}
	public void withdraw(float ammount,ATM a) {
		float bal=a.getBalance();
		if(bal<ammount)
		{
			System.out.println("Insufficient Balance Break");
			return;
		}
		bal-=ammount;
		a.setBalance(bal);
	}
	
	
	
	public float getBalance(ATM a) {
		float bal=a.getBalance();
		return bal;	
	}
	
	
	public boolean ValidatePin(int pin,ATM a) {
		int pin1=a.getPin();
		return pin1==pin;
	}
	
	public void ChangePin(int newPin,ATM a) {
		a.setPin(newPin);
	}
	
	
}
