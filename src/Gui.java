import Model.Restaurant;
import View.OrderPanel;
import View.RestaurantPanel;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Gui {
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
		JFrame frame = new JFrame("Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 500);
		frame.setMinimumSize(new Dimension(650, 500));
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel orderPanel = new OrderPanel(restaurant);
		tabbedPane.add("Model.Order", orderPanel);
		JPanel restaurantPanel = new RestaurantPanel(restaurant);
		tabbedPane.add("Model.Restaurant", restaurantPanel);
		frame.add(tabbedPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
