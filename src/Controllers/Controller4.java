package Controllers;

import Controllers.Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Model.Order;
import Model.Restaurant;
import View.*;

public class Controller4 extends MouseAdapter {
	public Restaurant restaurant;
	private JPanel panel;
	private JComboBox combo;
	private JSpinner spin;
	private static double totPrice = 0;
	private static double totExpense = 0;

	public Controller4(Restaurant restaurant, JPanel panel, JComboBox combo, JSpinner spin) {
		this.restaurant = restaurant;
		this.panel = panel;
		this.combo = combo;
		this.spin = spin;
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			Order order = new Order();
			if (this.panel instanceof OrderPanel && button.getText().equals("Add")) {
				String a = String.valueOf(this.combo.getSelectedItem());
				int b = (int) this.spin.getValue();
				((OrderPanel) this.panel).sp.setValue(0);
				double price = 0;
				double expense = 0;
				for (int i = 0; i < this.restaurant.getProducts().size(); i++) {
					if (this.restaurant.getProducts().get(i).getName().equals(a)) {
						price += (this.restaurant.getProducts().get(i).getSellingPrice()) * b;
						order.addProduct(restaurant.getProducts().get(i));
						((OrderPanel) this.panel).model.addRow(new Object[] { a, b, price });
						totPrice += price;
						expense += (this.restaurant.getProducts().get(i).getPurchasePrice()) * b
								+ (this.restaurant.getProducts().get(i).getUtilityCost()) * b;
						totExpense += expense;
					}
				}
			} else if (this.panel instanceof OrderPanel && button.getText().equals("Finalize")) {
				((OrderPanel) this.panel).getRandomWaiter().createOrder(order);
				double exp = Double.parseDouble(RestaurantPanel.calExp.getText()) + totExpense;
				RestaurantPanel.calExp.setText(Double.toString(exp));
				double selling = Double.parseDouble(RestaurantPanel.calRev.getText()) + totPrice;
				RestaurantPanel.calRev.setText(Double.toString(selling));
				RestaurantPanel.proVal.setText(Double.toString(selling - exp));
				JOptionPane.showMessageDialog(null,
						"Your order is completed.\n" + "Total price is " + totPrice + " TL");
				int rowCount = ((OrderPanel) this.panel).model.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					((OrderPanel) this.panel).model.removeRow(0);
				}
				((OrderPanel) this.panel).sp.setValue(0);
				((OrderPanel) this.panel).combo.setSelectedIndex(0);
				((OrderPanel) this.panel).price.setText("0.0 TL");
				((OrderPanel) this.panel).removeAll();
				totPrice = 0;
				this.panel.setLayout(new FlowLayout());
				JButton but = new JButton("New Model.Order");
				but.addMouseListener(new Controller(this.restaurant, this.panel));
				((OrderPanel) this.panel).add(but);
				((OrderPanel) this.panel).revalidate();
				((OrderPanel) this.panel).repaint();
			}
		}
	}
}
