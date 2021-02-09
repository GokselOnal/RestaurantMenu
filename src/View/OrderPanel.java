package View;

import Controllers.Controller;
import Controllers.Controller4;
import Controllers.Controller5;
import Model.Restaurant;
import Model.Waiter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;



public class OrderPanel extends JPanel {
	private Restaurant restaurant;
	private ArrayList<JPanel> oPanels = new ArrayList<JPanel>();
	public Waiter randomWaiter;
	public DefaultTableModel model;
	public JComboBox combo;
	public JSpinner sp;
	public JLabel price;

	public OrderPanel(Restaurant restaurant){
		this.restaurant = restaurant;
		JButton button = new JButton("New Model.Order");
		button.addMouseListener(new Controller(restaurant,this));
		this.add(button);
		this.oPanels.add(getNewOrder1());
		this.oPanels.add(getNewOrder2());
	}

	 public JPanel getNewOrder1() {
		JPanel newOrder1Panel = new JPanel();
		newOrder1Panel.setLayout(new GridLayout(5,2));
		JLabel lab1 = new JLabel("Add Model.Product");
		JLabel lab2 = new JLabel("Model.Product:");
		String[] productsName = new String[restaurant.getProducts().size()];
		for(int i = 0 ; i < restaurant.getProducts().size() ; i++) {
			productsName[i] = restaurant.getProducts().get(i).getName();
		}
		JLabel lab3 = new JLabel("Price:");
		this.price = new JLabel("0.0 TL");
		JLabel l5 = new JLabel();
		JLabel l6 = new JLabel();
		this.combo = new JComboBox(productsName);
		this.combo.addActionListener((new Controller5(restaurant,this,this.price)));
		JLabel lcount = new JLabel("Count:");
		this.sp= new JSpinner();
		JButton button = new JButton("Add");
		button.addMouseListener(new Controller4(restaurant,this,combo,sp));
		newOrder1Panel.add(lab1);
		newOrder1Panel.add(l6); //empty
		newOrder1Panel.add(lab2);
		newOrder1Panel.add(combo);
		newOrder1Panel.add(lcount);
		newOrder1Panel.add(sp);
		newOrder1Panel.add(lab3);
		newOrder1Panel.add(this.price);
		newOrder1Panel.add(l5); //empty
		newOrder1Panel.add(button);
		return newOrder1Panel;
	}

	public JPanel getNewOrder2() {
		JPanel newOrder2Panel = new JPanel();
		newOrder2Panel.setLayout(new BorderLayout());
		JLabel labell = new JLabel("Current Model.Order");
		JButton fin = new JButton("Finalize");
		fin.addMouseListener(new Controller4(restaurant,this,combo,sp));
		JTable tab = new JTable();
		JScrollPane sp=new JScrollPane(tab); 
		model = new DefaultTableModel() ;
		tab.setModel(model);
		model.addColumn("Model.Product Name");
		model.addColumn("Count");
		model.addColumn("Price");
		newOrder2Panel.add(labell, BorderLayout.NORTH);
		newOrder2Panel.add(sp,BorderLayout.CENTER);
		newOrder2Panel.add(fin, BorderLayout.SOUTH);
		return newOrder2Panel;
	}
	
	public ArrayList<JPanel> getPanel(){
		return oPanels;
	}

	public Waiter getRandomWaiter() {
		return randomWaiter;
	}
}
