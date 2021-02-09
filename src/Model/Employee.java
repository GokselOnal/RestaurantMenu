package Model;

public abstract class Employee implements Expense {
	private int id;
	private String name;

	public Employee(int id ,String name) {
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Model.Employee " + this.id + ": " + this.name;
	}
}


