package atmInterface;

import atm.ATM;
//Use Interface For achive 100% abstraction
public interface ATMInterface {

	public void displayMenu();
	public void deposit(float Ammount,ATM a);
	public void withdraw(float ammount,ATM a);
	public float getBalance(ATM a);
	public boolean ValidatePin(int pin,ATM a);
	public void ChangePin(int newPin,ATM a);
}
