package Model;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {
	Random rand = new Random();
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private ArrayList<Product> products = new ArrayList<Product>();
	int tempId = 1;
	
	public Restaurant() {
		initEmployees();
		initProducts();
	}

	private void initEmployees() {
		addCook("Monica", 100);
		addWaiter("Ross");
		addWaiter("Phobe");
		addWaiter("Rachel");
	}
	
	private void initProducts() {
		products.add(new MainDish("Pizza", 6, 2, 2));
		products.add(new MainDish("Burger", 5, 1.5, 2));
		products.add(new Beverage("Coke", 2, 0.5));
		products.add(new Beverage("Lemonade", 2, 0.3));
		products.add(new Dessert("Tiramusu", 4, 1, 1));
		products.add(new Dessert("Cake", 3, 0.5, 1));
		products.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
		
		ArrayList<Product> HGproducts = new ArrayList<>();
		HGproducts.add(new MainDish("Pizza", 6, 2, 2));
		HGproducts.add(new Beverage("Coke", 2, 0.5));
		HGproducts.add(new Dessert("Tiramusu", 4, 1, 1));
		products.add(new MenuProduct("Hunger Games Menu", HGproducts));
		
		ArrayList<Product> Kidsproducts = new ArrayList<>();
		Kidsproducts.add(new MainDish("Burger", 5, 1.5, 2));
		Kidsproducts.add(new Beverage("Lemonade", 2, 0.3));
		Kidsproducts.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
		products.add(new MenuProduct("Kids Menu", Kidsproducts));
	}
	
	public void listEmployees() {
		for(int i = 0 ; i < employees.size() ; i++) {
			System.out.println(employees.get(i));
		}
	}

	public void addCook(String cook_name , double salary) {
		employees.add(new Cook(tempId,cook_name,salary));
		tempId++;
	}


	public void addWaiter(String waiter_name) {
		employees.add(new Waiter(tempId,waiter_name));
		tempId++;
	}	
	
	public Waiter assignWaiter() {
		ArrayList<Integer> waiterNumbers = new ArrayList<Integer>();
		for(int i = 0 ; i < employees.size() ; i++) {
			if(employees.get(i) instanceof Waiter) {
				waiterNumbers.add(employees.get(i).getId());
			}
		}
		int randomWaiter = rand.nextInt(waiterNumbers.size());
		return  (Waiter)employees.get((waiterNumbers.get(randomWaiter)-1));
	}
	
	public double calculateExpenses() {
		double employeeExpenses = 0;
		for(int i = 0 ; i < employees.size() ; i++) {
			if(employees.get(i) instanceof Cook) {
				Employee cook = employees.get(i);
				double cookSalary = ((Cook)cook).calculateExpense();
				employeeExpenses += cookSalary;
			}
			else if(employees.get(i) instanceof Waiter) {
				Employee waiter = employees.get(i);
				double waiterSalary = ((Waiter)waiter).calculateExpense();
				employeeExpenses += waiterSalary;
			}
		}
			double orderExpenses = 0;
			for(int j = 0 ; j < employees.size() ; j++) {
				if(employees.get(j) instanceof Waiter) {
					ArrayList<Order> receivedOrder = ((Waiter)employees.get(j)).getOrdersReceived();
					for(int k = 0 ; k < receivedOrder.size() ; k++) {
						ArrayList<Product> receivedProduct = receivedOrder.get(k).getOrderedProducts();

						for(int t = 0 ; t < receivedProduct.size() ; t++) {
							if(receivedProduct.get(t) instanceof MainDish) {
								double mainDishExpense = ((MainDish)receivedProduct.get(t)).calculateExpense();
								orderExpenses += mainDishExpense;
							}
							else if(receivedProduct.get(t) instanceof Dessert) {
								double dessertExpense = ((Dessert)receivedProduct.get(t)).calculateExpense();
								orderExpenses += dessertExpense;
							}
							else if(receivedProduct.get(t) instanceof Beverage) {
								double beverageExpense = ((Beverage)receivedProduct.get(t)).calculateExpense();
								orderExpenses += beverageExpense;
							}
							else if(receivedProduct.get(t) instanceof MenuProduct) {
								double MenuProductExpense = ((MenuProduct)receivedProduct.get(t)).calculateExpense();
								orderExpenses += MenuProductExpense;
						}
					}
				}
			}
		}
		//System.out.println("Model.Employee expenses: " + employeeExpenses);
		//System.out.println("Model.Order expenses: " + orderExpenses);
		return employeeExpenses + orderExpenses;
	}
	
	public double calculateRevenue() {
		double revenue = 0;
		for(int i = 0 ; i < employees.size() ; i++) {
			if(employees.get(i) instanceof Waiter) {
				ArrayList<Order> receivedOrder = ((Waiter)employees.get(i)).getOrdersReceived();
				for(int j = 0 ; j < receivedOrder.size() ; j++) {
					double sellingPrice = receivedOrder.get(j).calculateTotalPrice();
					revenue += sellingPrice;
				}
			}
		}
		return revenue; 
	}
	
	public ArrayList<Product> getProducts(){
		return products;
	}
	
	public ArrayList<Employee> getEmployees(){
		return employees;
	}


	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

}
