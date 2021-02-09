package Controllers;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Restaurant;
import View.*;

public class Controller3 extends MouseAdapter {
	public Restaurant restaurant;
	private JTextField text;
	private JTextField text2;
	private JPanel panel;

	public Controller3(Restaurant restaurant, JPanel panel, JTextField text, JTextField text2) {
		this.restaurant = restaurant;
		this.text = text;
		this.panel = panel;
		this.text2 = text2;
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if (this.panel instanceof RestaurantPanel && button.getText().equals("Add")) {
				double salary;
				try {
					salary = Double.parseDouble(this.text2.getText());
					this.restaurant.addCook(this.text.getText(), salary);
					((RestaurantPanel) this.panel).getPanel().set(0, ((RestaurantPanel) this.panel).getListEmployees());
					((RestaurantPanel) this.panel).getPanel().set(3,
							((RestaurantPanel) this.panel).getCalculateExpense());
					JOptionPane.showMessageDialog(null, "Model.Cook added succesfully");
					this.text.setText(" ");
					this.text2.setText(" ");
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Invalid number: " + this.text2.getText() + "\n" + "Try again");
					this.text.setText(" ");
					this.text2.setText(" ");
				}
			}
		}
	}
}
