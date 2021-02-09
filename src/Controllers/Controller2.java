package Controllers;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Restaurant;
import View.*;

public class Controller2  extends MouseAdapter {
	public Restaurant restaurant ;
	private JTextField text;
	private JPanel panel;

	public Controller2(Restaurant restaurant, JPanel panel , JTextField text) {
		this.text = text;
		this.panel = panel;
		this.restaurant = restaurant;
	}

	public void mousePressed(MouseEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton button = (JButton)e.getSource();
			if(this.panel instanceof RestaurantPanel && button.getText().equals("Add")) {
				this.restaurant.addWaiter(this.text.getText());
				((RestaurantPanel)this.panel).getPanel().set(0, ((RestaurantPanel)this.panel).getListEmployees());
				this.restaurant.setEmployees(this.restaurant.getEmployees());
				this.text.setText(" ");
				JOptionPane.showMessageDialog(null, "Model.Waiter added succesfully");
			}
		}
	}
}
