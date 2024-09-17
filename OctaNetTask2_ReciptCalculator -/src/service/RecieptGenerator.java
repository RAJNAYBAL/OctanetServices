package service;

import java.io.FileWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Model.FoodOrdered;
//Used Inheritance Using Implements we can Override Parent Interface Methods
public class RecieptGenerator implements ReciptGeneratorInterface {

	private final static double sgstTax=0.07;
	private final static  double cgstTax=0.1;

    public RecieptGenerator() {
		super();
	}  
	Scanner sc=new Scanner(System.in);

//override addProduct() from Interface it used to add Products
//Veg and Non-veg Product are there 
//orderd multiple products and stored in flist refrence Of ArrayList
//after added this Lists in Map as a Values 
	@Override
	public HashMap<String ,List<FoodOrdered>> addProduct() {
		FoodOrdered product=new FoodOrdered();
		List<FoodOrdered> flist=new ArrayList<FoodOrdered>();
		List<FoodOrdered> vegList=new ArrayList<FoodOrdered>();
		HashMap<String ,List<FoodOrdered>> maplst=new HashMap<>();
		Boolean b;
		while(true) {

			System.out.println("=================MENU CARD===================");
			System.out.println("1 :\t VEG  \n2 :\t NON-VEG \n3 :\t Exit");
			System.out.println("Enter Your Choice");
			int c=sc.nextInt();

			if(c==1)
			{
				b=true;
				System.out.println("============= VEG ===================");
				System.out.println("Sr.No\t Name \t price");
				System.out.println("1: \tApple \t 100 \n2: \tBanana \t 40 \n3: \tMango \t 150\n4: \tFinish");
				while(b) {
					System.out.println("What you want to buy Please choce the Option");
					int ch=sc.nextInt();
					sc.nextLine();
					switch(ch)
					{

					case 1:
						System.out.println("Enter the Quntity");
						int qty=sc.nextInt();
						product=new FoodOrdered("Apple", 100, qty);
						vegList.add(product);
						break;

					case 2:
						System.out.println("Enter the Quntity");
						qty=sc.nextInt();
						product=new FoodOrdered("Banana", 40, qty);
						vegList.add(product);
						break;

					case 3:
						System.out.println("Enter the Quntity");
						qty=sc.nextInt();
						product=new FoodOrdered("Mango", 150, qty);
						vegList.add(product);
						break;

					default :
						b=false;
						break;

					}	
				}
			}

			else if(c==2) {
				System.out.println("============= NON-VEG ===================");
				System.out.println("1: \tEgg \t 60 \n2: \tChicken \t 300 \n3: \tFish \t 200 \n4 \tFinish");
				b=true;
				while(b) {
					System.out.println("What you want to buy Please choce the Option");
					int ch1=sc.nextInt();
					sc.nextLine();
					switch(ch1)
					{

					case 1:
						System.out.println("Enter the Quntity");
						int qty=sc.nextInt();
						product=new FoodOrdered("Egg", 60, qty);
						flist.add(product);
						break;

					case 2:
						System.out.println("Enter the Quntity");
						qty=sc.nextInt();
						product=new FoodOrdered("Chicken", 300, qty);
						flist.add(product);
						break;

					case 3:
						System.out.println("Enter the Quntity");
						qty=sc.nextInt();
						product=new FoodOrdered("Fish", 200, qty);
						flist.add(product);
						break;

					default:
						b=false;
						break;
					}
				}
			}

			else			{
				System.out.println("----Thank You---");
				maplst.put("veg", vegList);
				maplst.put("non-veg", flist);
				return maplst;

			}		
		}
	}

	//	public void display(List<FoodOrdered> flist)
	//	{
	//		System.out.println("You Ordered :\n");
	//		for(FoodOrdered p:flist)
	//		{
	//			System.out.println(p);
	//		}
	//	}



//override displayMap() from Interface it used to Display OderedProducts
//Retrive data From Map
	@Override
	public void displayMap(HashMap<String, List<FoodOrdered>> Maplst)
	{

		do {
			Set<String> keys=Maplst.keySet();
			System.out.println("\n Which Data Do You Ordered Want to See");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - ");
			System.out.println("\n 1 : Veg  \n 2 : Non-Veg \n 3 : All");
			int choice = sc.nextInt();

			switch(choice)
			{

			case 1:
				for(String key:keys)
				{
					if(key.equalsIgnoreCase("veg"))
					{
						System.out.println("You Odered Veg :");
						List<FoodOrdered> veglst=Maplst.get(key);
						for(FoodOrdered x:veglst)
						{
							System.out.println(x);
						}
					}
				}
				break;

			case 2:
				for(String key:keys)
				{
					if(key.equalsIgnoreCase("non-veg"))
					{
						System.out.println("You Odered NON-Veg :");
						List<FoodOrdered> veglst=Maplst.get(key);
						for(FoodOrdered x:veglst)
						{
							System.out.println(x);
						}
					}
				}
				break;

			case 3:
				System.out.println("All Ordered : ");
				for(Map.Entry<String,List<FoodOrdered>> allData:Maplst.entrySet())
				{
					System.out.println("Type : "+allData.getKey());
					List<FoodOrdered> lst=allData.getValue();
					System.out.println("Name\t Price\t  Quntity");
					for(FoodOrdered o:lst)
					{
						System.out.println(o.getProdName()+"\t"+o.getProdPrice()+"\t"+o.getQuntity());
					}
					//	System.out.println(allData.getValue());

				}
				break;
			}
			System.out.println("do you want to cntinoue Press 1");
		}while(sc.nextInt()==1);
	}

//override FinalBill() from Interface it used to create Bill Calulation
	@Override
	public void FinalBill(HashMap<String, List<FoodOrdered>> Maplst) {
		double total=0;
		double finaltotal=1;
		double cgst=0;
		double sgst=0;
		System.out.println(  "                    ****FINAL BILL****                        \n");
		System.out.println("==================================================================");
		System.out.println("Name\tPrice \t  Quntity \tTotal \tCGST \tSGST\tTotal");
		System.out.println("==================================================================");

		for(Map.Entry<String,List<FoodOrdered>> allData:Maplst.entrySet())
		{
			//System.out.println("Type : "+allData.getKey());
			List<FoodOrdered> lst=allData.getValue();
			for(FoodOrdered o:lst)
			{
				cgst=0;
				sgst=0;
				finaltotal=o.getQuntity()*o.getProdPrice();
				cgst+=finaltotal*cgstTax;
				sgst+= Math.round(finaltotal*sgstTax);
				total+=(finaltotal+cgst+sgst);

				System.out.println(o.getProdName()+"\t"+o.getProdPrice()+"\t\t"+o.getQuntity()+"\t"+finaltotal+"\t"+cgst+"\t"+sgst+"\t"+(finaltotal+cgst+sgst));
				System.out.println();
			}
		}

		System.out.println("==================================================================");
		System.out.println("\t\tFinal Total : "+(total));
		System.out.println("\t====================================");
	}

	
//override SaveReciptToFile() from Interface it used to Save the Text copy of Bill on Local System
	@Override
	public void SaveReciptToFile(String fileName,HashMap<String,List<FoodOrdered>> Maplst) {
		try(FileWriter writer=new FileWriter("E:/OctaNetInternship/"+fileName+".txt"))
		{

			double total=0;
			double finaltotal=1;
			double cgst=0;
			double sgst=0;
			writer.write(  "                    ****FINAL BILL****                        \n");
			writer.write("==================================================================\n");
			writer.write("Name\tPrice \t  Quntity \tTotal \tCGST \tSGST\tTotal\n");
			writer.write("==================================================================\n");

			for(Map.Entry<String,List<FoodOrdered>> allData:Maplst.entrySet())
			{


				//System.out.println("Type : "+allData.getKey());
				List<FoodOrdered> lst=allData.getValue();
				for(FoodOrdered o:lst)
				{
					cgst=0;
					sgst=0;
					finaltotal=o.getQuntity()*o.getProdPrice();
					cgst+=finaltotal*cgstTax;
					sgst+= Math.round(finaltotal*sgstTax);
					total+=(finaltotal+cgst+sgst);

					writer.write(o.getProdName()+"\t"+o.getProdPrice()+"\t\t"+o.getQuntity()+"\t"+finaltotal+"\t"+cgst+"\t"+sgst+"\t"+(finaltotal+cgst+sgst));
				}
			}
			writer.write("==================================================================\n");
			writer.write("\t\tFinal Total : "+(total));
			writer.write("\t\n====================================\n");
			writer.write("Reciept:\n");
			writer.write("=======================\n");
		}
		catch(Exception e)
		{
			System.out.println("Error Writing to File"+e.getMessage());
		}
	}
}
