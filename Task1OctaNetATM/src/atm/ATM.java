package atm;
//Model Class
public class ATM {

	private float balance;
	private int pin;
	
	
	public ATM() {
		super();
	}
	public ATM(float balance, int pin) {
		super();
		this.balance = balance;
		this.pin = pin;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
