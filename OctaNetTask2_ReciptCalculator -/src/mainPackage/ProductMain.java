package mainPackage;

import java.util.HashMap;
import java.util.List;

import java.util.Scanner;

import Model.FoodOrdered;
import service.RecieptGenerator;
import service.ReciptGeneratorInterface;

public class ProductMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ReciptGeneratorInterface rgi=new RecieptGenerator();
		HashMap<String,List<FoodOrdered>> mplst = null;
		Boolean b=true;
		while(b) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("\n1 : Order Your Product \n2 : Display Ordered Product \n3 : Bill \n4 : Save To File \n5 : Exit");
			System.out.println("Enter Your Choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				mplst= rgi.addProduct();
				break;

			case 2:
				rgi.displayMap(mplst);
				break;

			case 3:
				rgi.FinalBill(mplst);
				break;

			case 4:
				System.out.println("Do you want to save the receipt to a file? (yes/no):");
				String saveToFile=sc.next();
				if(saveToFile.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter fileName :");
					String fileName=sc.next();
					rgi.SaveReciptToFile(fileName, mplst);
					System.out.println("Reciept saved to fileName :"+fileName);
				}
				break;
			default :
				sc.close();
				b=false;
				break;
			}
		}



	}

}
