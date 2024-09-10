package MainPak;

import java.util.Scanner;
//Main Method
import atm.ATM;
import atmInterface.ATMImplmentation;
import atmInterface.ATMInterface;

public class ATMain 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		ATM a=new ATM(1000,1234);

		ATMInterface atmObj=new ATMImplmentation();

		System.out.print("Enter Pin : ");
		int pin=sc.nextInt();


		if(atmObj.ValidatePin(pin,a)) {
			int choice=0;

			while(choice!=5) 
			{
				System.out.println("==========================================");
				atmObj.displayMenu();
				System.out.println("Enter Your Choice");
				choice=sc.nextInt();

				switch(choice)
				{
				case 1:
					float bal=atmObj.getBalance(a);
					System.out.println("Balance is  : "+bal);
					break;

				case 2:
					System.out.print("Enter Ammount : ");
					float amt=sc.nextFloat();
					atmObj.deposit(amt, a);
					System.out.println("Ammount Depositeed : "+amt);
					break;

				case 3:
					System.out.print("Enter Ammount :");
					amt=sc.nextFloat();
					atmObj.withdraw(amt, a);
					System.out.println("Succefully Withdraw : "+amt);
					System.out.println("**Remaing Balance** : "+a.getBalance());
					break;

				case 4:
					System.out.print("Enter  New Pin : ");
					int newPin=sc.nextInt();
					atmObj.ChangePin(newPin, a);
					System.out.println("Successfully Changed ");
					break;

				case 5:
					System.out.println("Thank You ! Visit Again");
					break;

				default:
					System.out.println("Enter Correct Choice");
				}
			}
		}
		else {

			System.out.println("You have entered Invalid Pin!");
		}
	}
}
