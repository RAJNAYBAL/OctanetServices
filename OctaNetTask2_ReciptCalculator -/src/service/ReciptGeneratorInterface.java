package service;

import java.util.HashMap;
import java.util.List;

import Model.FoodOrdered;
//Using Interface Achive Abstraction Strong Secuirity
public interface ReciptGeneratorInterface {

	public  HashMap<String,List<FoodOrdered>>  addProduct();
	public void displayMap(HashMap<String,List<FoodOrdered>> Maplst);
	public void FinalBill(HashMap<String,List<FoodOrdered>> Maplst);
	void SaveReciptToFile(String fileName, HashMap<String, List<FoodOrdered>> Maplst1);
	
}
