package View;

import Controllers.Controller;
import Controllers.Controller2;
import Controllers.Controller3;
import Model.Cook;
import Model.Employee;
import Model.Restaurant;
import Model.Waiter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RestaurantPanel extends JPanel {
	private Restaurant restaurant;
	private ArrayList<JPanel> rPanels = new ArrayList<JPanel>();
	public JButton button1 = new JButton("List Employess");
	public JButton button2= new JButton("Add Model.Cook");
	public JButton button3= new JButton("Add Model.Waiter");
	public JButton button4= new JButton("Calculate Expenses");
	public static JLabel calExp;
	public static JLabel calRev;
	public static JLabel proVal;

	public RestaurantPanel(Restaurant restaurant) {
		this.restaurant = restaurant;
		button1.addMouseListener(new Controller(restaurant,this));
		button2.addMouseListener(new Controller(restaurant,this));
		button3.addMouseListener(new Controller(restaurant,this));
		button4.addMouseListener(new Controller(restaurant,this));

		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		
		this.rPanels.add(getListEmployees());
		this.rPanels.add(getAddCook());
		this.rPanels.add(getAddWaiter());
		this.rPanels.add(getCalculateExpense());
	}
	
	public JPanel getAddCook() {
		JPanel addCookPanel = new JPanel();
		addCookPanel.setLayout(new GridLayout(5,2));
		
		JLabel bos = new JLabel(" ");
		JLabel bos1 = new JLabel(" ");
		JLabel bos2 = new JLabel(" ");
		JLabel bos3 = new JLabel(" ");
		JLabel bos4 = new JLabel(" ");

		addCookPanel.add(bos);
		addCookPanel.add(bos1);
		addCookPanel.add(bos2);
		addCookPanel.add(bos3);
		
		JLabel name = new JLabel("Name:");
		JTextField text = new JTextField(" ");
		JLabel salary = new JLabel("Salary:");
		JTextField text2 = new JTextField(" ");
		JButton button = new  JButton("Add");
		button.addMouseListener(new Controller3(this.restaurant,this,text,text2));
		
		addCookPanel.add(name);
		addCookPanel.add(text);
		addCookPanel.add(salary);
		addCookPanel.add(text2);
		addCookPanel.add(bos4);
		addCookPanel.add(button);
		
		return addCookPanel;
	}
	
	public JPanel getAddWaiter() {
		JPanel addWaiterPanel = new JPanel();
		addWaiterPanel.setLayout(new GridLayout(4,2));

		JLabel bos = new JLabel(" ");
		JLabel bos1 = new JLabel(" ");
		JLabel bos2 = new JLabel(" ");
		JLabel bos3 = new JLabel(" ");
		JLabel bos4 = new JLabel(" ");

		addWaiterPanel.add(bos);
		addWaiterPanel.add(bos1);
		addWaiterPanel.add(bos2);
		addWaiterPanel.add(bos3);
		
		JLabel name = new JLabel("Name:");
		JTextField text = new JTextField(" ");
		JButton button = new  JButton("Add");
		button.addMouseListener(new Controller2(this.restaurant,this,text));

		addWaiterPanel.add(name);
		addWaiterPanel.add(text);
		addWaiterPanel.add(bos4);
		addWaiterPanel.add(button);
		return addWaiterPanel;
	}
	
	public JPanel getCalculateExpense() {
		JPanel calculateExpensePanel = new JPanel();
		calculateExpensePanel.setLayout(new GridLayout(5,2));

		JLabel bos = new JLabel(" ");
		JLabel bos1 = new JLabel(" ");
		JLabel bos2 = new JLabel(" ");
		JLabel bos3 = new JLabel(" ");
		JLabel bos4 = new JLabel(" ");

		JLabel expenses = new JLabel("Expenses: ");
		JLabel revenue = new JLabel("Revenue: ");
		JLabel profit = new JLabel("Profit: ");
		
		double calculateExpense = (restaurant.calculateExpenses());
		double calculateRevenue = (restaurant.calculateRevenue());
		String profitValue = String.valueOf( restaurant.calculateRevenue() - restaurant.calculateExpenses());
		
		this.calExp = new JLabel(String.valueOf(calculateExpense));
		this.calRev = new JLabel(String.valueOf(calculateRevenue));
		this.proVal = new JLabel(profitValue);
		
		calculateExpensePanel.add(bos);
		calculateExpensePanel.add(bos1);
		calculateExpensePanel.add(bos2);
		calculateExpensePanel.add(bos3);
		calculateExpensePanel.add(expenses);
		calculateExpensePanel.add(calExp);
		calculateExpensePanel.add(revenue);
		calculateExpensePanel.add(calRev);
		calculateExpensePanel.add(profit);
		calculateExpensePanel.add(proVal);
		
		return calculateExpensePanel;
	}
	
	public JPanel getListEmployees() {
		ArrayList<Employee> emps = restaurant.getEmployees();
		JPanel listEmployeesPanel = new JPanel();
		listEmployeesPanel.setLayout(new GridLayout(emps.size()+3,3));
		
		ArrayList<String> employeesName = new ArrayList<String>();
		ArrayList<Integer> employeesId = new ArrayList<Integer>();
		
		for(int i = 0 ; i < emps.size() ; i++) {
			if(emps.get(i) instanceof Waiter) {
				employeesId.add(((Waiter)emps.get(i)).getId());
				employeesName.add(((Waiter)emps.get(i)).getName());
			}
			else if (emps.get(i) instanceof Cook) {
				employeesId.add(((Cook)emps.get(i)).getId());
				employeesName.add(((Cook)emps.get(i)).getName());
			}
		}
		ArrayList<String> sirali = new ArrayList<String>();

		for(int i = 0 ; i <employeesId.size() ; i++ ) {
			sirali.add(employeesName.get(employeesId.get(i) -1));
		}
		JLabel bos = new JLabel(" ");
		JLabel bos1 = new JLabel(" ");
		JLabel bos2 = new JLabel(" ");
		JLabel bos3 = new JLabel(" ");
		JLabel bos4 = new JLabel(" ");
		JLabel bos5 = new JLabel(" ");

		listEmployeesPanel.add(bos);
		listEmployeesPanel.add(bos1);
		listEmployeesPanel.add(bos2);
		listEmployeesPanel.add(bos3);
		listEmployeesPanel.add(bos4);
		listEmployeesPanel.add(bos5);

		JLabel sayi = new JLabel("0");
		sayi.setForeground(Color.RED);
		JLabel name = new JLabel("Name");
		name.setForeground(Color.RED);
		JLabel job = new JLabel("Job");
		job.setForeground(Color.RED);
		listEmployeesPanel.add(sayi);
		listEmployeesPanel.add(name);
		listEmployeesPanel.add(job);

		for(int k = 0 ; k < sirali.size() ; k++) {
			listEmployeesPanel.add(new JLabel(Integer.toString(k+1)));
			listEmployeesPanel.add(new JLabel(sirali.get(k)));
			if(emps.get(k) instanceof Waiter) {
				listEmployeesPanel.add(new JLabel("Model.Waiter"));
			}
			else if(emps.get(k) instanceof Cook) {
				listEmployeesPanel.add(new JLabel("Model.Cook"));
			}
		}
		return listEmployeesPanel;
	}
	
	public ArrayList<JPanel> getPanel(){
		return rPanels;
	}
}
