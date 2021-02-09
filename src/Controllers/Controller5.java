package Controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Product;
import Model.Restaurant;
import View.*;


public class Controller5 implements ActionListener {
	public Restaurant restaurant;
	private JPanel panel;
	private JLabel label;
	public Controller5(Restaurant restaurant, JPanel panel, JLabel label) {
		this.restaurant = restaurant;
		this.panel = panel;
		this.label = label;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JComboBox) {
			JComboBox combo = (JComboBox) e.getSource();
			Product p;
			if (this.panel instanceof OrderPanel) {
				for (int i = 0; i < this.restaurant.getProducts().size(); i++) {
					if (String.valueOf(combo.getSelectedItem())
							.equals(this.restaurant.getProducts().get(i).getName())) {
						p = this.restaurant.getProducts().get(i);
						this.label.setText(Double.toString(p.getSellingPrice()) + " TL");

					}
				}
			}
		}
	}
}
