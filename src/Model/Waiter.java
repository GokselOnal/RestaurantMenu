package Model;

import java.util.ArrayList;

public class Waiter extends Employee {
	private double orderRate;
	private ArrayList<Order> receivedOrders;
	
	public Waiter(int id , String name) {
		super(id,name);
		this.orderRate = (0.10);
		this.receivedOrders = new ArrayList<Order>();
	}
	
	@Override
	public double calculateExpense() {
		double totWaiterExpense = 0;
		for(int i = 0 ; i < receivedOrders.size() ; i++) {
			totWaiterExpense += (receivedOrders.get(i).calculateTotalPrice() * orderRate);
		}
		return totWaiterExpense;
	}
	
	public void createOrder(Order order) {
		receivedOrders.add(order);
	}
	
	public ArrayList<Order> getOrdersReceived(){
		return receivedOrders;
	}
	
}


