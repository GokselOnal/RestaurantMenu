package Model;

public class Cook extends Employee {
	private double salary;
	private double taxRate;
	
	public Cook(int id , String name, double salary) {
		super(id,name);
		this.salary = salary;
		this.taxRate = 0.18;
	}

	public double getSalary() {
		return salary;
	}

	public double getTaxRate() {
		return taxRate;
	}

	@Override
	public double calculateExpense() {
		return (this.salary + (this.salary * this.taxRate));
	}
}


