package Model;

import java.util.ArrayList;

public class MenuProduct extends Product {
	private ArrayList<Product> productsInMenu;
	
	public MenuProduct(String name, ArrayList<Product> products) {
		super(name);
		this.productsInMenu = products;
		this.setSellingPrice(calculateSellingPrice());
	}

	@Override
	public double calculateExpense() {
		double totExpense = 0;
		for(int i = 0 ; i < productsInMenu.size() ; i++) {
			if(productsInMenu.get(i) instanceof MainDish) {
				double mainDishExpense =((MainDish) productsInMenu.get(i)).calculateExpense();
				totExpense += mainDishExpense;
			}
			else if(productsInMenu.get(i) instanceof Dessert) {
				double dessertExpense = ((Dessert)productsInMenu.get(i)).calculateExpense();
				totExpense += dessertExpense;
			}
			else if(productsInMenu.get(i) instanceof Beverage) {
				double beverageExpense = ((Beverage)productsInMenu.get(i)).calculateExpense();
				totExpense += beverageExpense;
			}
		}
		return totExpense;
	}
	
	private double calculateSellingPrice() {
		double totSellingPrice = 0;
		for(int i = 0 ; i <productsInMenu.size(); i++) {
			if(productsInMenu.get(i) instanceof MainDish) {
				double mainDishDiscount =((MainDish)productsInMenu.get(i)).getSellingPrice() - ((MainDish)productsInMenu.get(i)).getSellingPrice() *(0.10);
				totSellingPrice += mainDishDiscount;
			}
			else if(productsInMenu.get(i) instanceof Dessert) {
				double dessertDiscount =((Dessert)productsInMenu.get(i)).getSellingPrice() - ((Dessert)productsInMenu.get(i)).getSellingPrice() *(0.20);
				totSellingPrice += dessertDiscount;	
			}
			else if(productsInMenu.get(i) instanceof Beverage) {
				double beverageDiscount =((Beverage)productsInMenu.get(i)).getSellingPrice() - ((Beverage)productsInMenu.get(i)).getSellingPrice() *(0.50);
				totSellingPrice += beverageDiscount;
			}
		}
		return totSellingPrice;
	}
}



