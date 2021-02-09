package Model;

public class Dessert extends Product {

	public Dessert(String name, double sellingPrice, double purchasePrice ,double utilityCost) {
		super(name,sellingPrice,purchasePrice,utilityCost);
	}
	
	@Override
	public double calculateExpense() {
		return this.getPurchasePrice() + this.getUtilityCost();
	}
}
