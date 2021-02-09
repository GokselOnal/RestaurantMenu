package Model;

import java.util.ArrayList;

public  class Order {
	private ArrayList<Product> orderedProducts; //ordered products

	public Order() {
		this.orderedProducts = new ArrayList<Product>();
	}
	
	public void addProduct(Product product) {
		orderedProducts.add(product);
	}
	
	public void listOrder() {
		if(orderedProducts.size() == 0) {
			System.out.println("You have not ordered anything yet!");
		}
		else {
			for(int i = 0 ; i < orderedProducts.size() ; i++) {
				System.out.println(orderedProducts.get(i));
			}	
		}
	}

	public ArrayList<Product> getOrderedProducts(){
		return orderedProducts;
	}
	
	public double calculateTotalPrice() {
		double totOrderPrice = 0;
		for(int i = 0 ; i < orderedProducts.size() ; i++) {
			totOrderPrice += orderedProducts.get(i).getSellingPrice();
		}
		return totOrderPrice;
	}
}


