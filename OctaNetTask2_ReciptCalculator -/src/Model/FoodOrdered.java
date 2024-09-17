package Model;
//Model Class Achive Encapsulation Hidding a Variable no one can access variable because they are Private
//For Access the the private Variable we use setter/getter Methods
public class FoodOrdered {
	private String prodName; 
	private double prodPrice;
	private int quntity;
	
	
	public FoodOrdered() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodOrdered(String prodName, double prodPrice, int quntity) {
		super();
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.quntity = quntity;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getQuntity() {
		return quntity;
	}
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	@Override
	public String toString() {
		return "FoodOrdered [prodName=" + prodName + ", prodPrice=" + prodPrice + ", quntity=" + quntity + "]";
	}
	
	

}
