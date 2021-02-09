package Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Restaurant;
import View.*;

public class Controller extends MouseAdapter {
	private JPanel panel;
	Restaurant restaurant;

	public Controller(Restaurant restaurant, JPanel panelll) {
		this.panel = panelll;
		this.restaurant = restaurant;
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton but = (JButton) e.getSource();
			if (this.panel instanceof OrderPanel && but.getText().equals("New Model.Order")) {
				this.panel.removeAll();
				this.panel.setLayout(new BorderLayout());
				this.panel.add(((OrderPanel) this.panel).getPanel().get(0), BorderLayout.NORTH);
				this.panel.add(((OrderPanel) this.panel).getPanel().get(1), BorderLayout.CENTER);
				this.panel.revalidate();
				this.panel.repaint();
				((OrderPanel) this.panel).randomWaiter = this.restaurant.assignWaiter();
				JOptionPane.showMessageDialog(null, "Hi, I am " + ((OrderPanel) this.panel).randomWaiter.getName()
						+ "\n" + "What would you like to order?");
			}

			else if (this.panel instanceof RestaurantPanel && but.getText().equals("List Employess")) {
				this.panel.removeAll();
				this.panel.add(((RestaurantPanel) panel).button1);
				this.panel.add(((RestaurantPanel) panel).button2);
				this.panel.add(((RestaurantPanel) panel).button3);
				this.panel.add(((RestaurantPanel) panel).button4);
				this.panel.setLayout(new BorderLayout());
				this.panel.add(((RestaurantPanel) this.panel).getPanel().get(0), BorderLayout.NORTH);
				this.panel.revalidate();
				this.panel.repaint();

			} else if (this.panel instanceof RestaurantPanel && but.getText().equals("Add Model.Cook")) {
				this.panel.removeAll();
				this.panel.add(((RestaurantPanel) panel).button1);
				this.panel.add(((RestaurantPanel) panel).button2);
				this.panel.add(((RestaurantPanel) panel).button3);
				this.panel.add(((RestaurantPanel) panel).button4);
				this.panel.setLayout(new BorderLayout());
				this.panel.add(((RestaurantPanel) this.panel).getPanel().get(1), BorderLayout.NORTH);
				this.panel.revalidate();
				this.panel.repaint();
			}

			else if (this.panel instanceof RestaurantPanel && but.getText().equals("Add Model.Waiter")) {
				this.panel.removeAll();
				this.panel.add(((RestaurantPanel) panel).button1);
				this.panel.add(((RestaurantPanel) panel).button2);
				this.panel.add(((RestaurantPanel) panel).button3);
				this.panel.add(((RestaurantPanel) panel).button4);
				this.panel.setLayout(new BorderLayout());
				this.panel.add(((RestaurantPanel) this.panel).getPanel().get(2), BorderLayout.NORTH);
				this.panel.revalidate();
				this.panel.repaint();
			}
			

			else if (this.panel instanceof RestaurantPanel && but.getText().equals("Calculate Expenses")) {
				this.panel.removeAll();
				this.panel.add(((RestaurantPanel) panel).button1);
				this.panel.add(((RestaurantPanel) panel).button2);
				this.panel.add(((RestaurantPanel) panel).button3);
				this.panel.add(((RestaurantPanel) panel).button4);
				this.panel.setLayout(new BorderLayout());
				this.panel.add(((RestaurantPanel) this.panel).getPanel().get(3), BorderLayout.NORTH);
				this.panel.revalidate();
				this.panel.repaint();
			}
		}
	}
}
