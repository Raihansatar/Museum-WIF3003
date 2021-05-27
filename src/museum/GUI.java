package museum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUI{
	
	private JFrame frame = new JFrame();	
	
	private JPanel panel_right = new JPanel();
	private JPanel panel_right_inner_1 = new JPanel();
	private JPanel panel_right_inner_2 = new JPanel();
	
	
	// Other componens
	private JLabel current_time;
	private JLabel museum_status;
	private JLabel counter_status;
	private JLabel remaining_tickets;
	private JLabel sold_tickets;
	private JLabel ticket_holder;
	private JLabel max_visitor;
	private JLabel current_visitor;
	
	//	static label
	private JLabel ticket_label;
	private JLabel visitor_label;
	private JLabel enter_gate;
	private JLabel exit_gate;

	private Border border = BorderFactory.createLineBorder(Color.BLACK,1);
	
	public GUI() {
		
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(1,2));
		
		current_time 		= createLabel("TIME: 00:00", false, true, 30);
		museum_status 		= createLabel("Museum", true, false, 12);
		counter_status 		= createLabel("Counter", true, false, 12);
		
		ticket_label 		= createLabel("Tickets", false, true, 20);
		remaining_tickets 	= createLabel("XXX", true, false, 12);
		sold_tickets 		= createLabel("XXX", true, false, 12);
		ticket_holder 		= createLabel("XXX", false, false, 12);

		visitor_label 		= createLabel("Visitor Count", false, true, 20);
		max_visitor 		= createLabel("XXX", true, false, 12);
		current_visitor 	= createLabel("XXX", true, false, 12);
		
		enter_gate 			= createLabel("Enter Gate", false, true, 20);
		exit_gate 			= createLabel("Exit Gate", false, true, 20);

		
		

		JPanel panel_left = createPanel(3, 1, true);
		JPanel panel_left_1 = createPanel(2, 1, true);
		JPanel panel_left_1_1 = createPanel(1, 2, false);
		
		panel_left_1_1.add(museum_status);
		panel_left_1_1.add(counter_status);
		
		panel_left_1.add(current_time);
		panel_left_1.add(panel_left_1_1);
		
		JPanel panel_left_2 = createPanel(3, 1, true);
		JPanel panel_left_2_1 = createPanel(1, 2, false);
		
		panel_left_2_1.add(remaining_tickets);
		panel_left_2_1.add(sold_tickets);
		
		panel_left_2.add(ticket_label);
		panel_left_2.add(panel_left_2_1);
		panel_left_2.add(ticket_holder);
		
		
		
		JPanel panel_left_3 = createPanel(2, 1, true);
		JPanel panel_left_3_1 = createPanel(1, 2, false);
		
		
		panel_left_3_1.add(max_visitor);
		panel_left_3_1.add(current_visitor);
		
		panel_left_3.add(visitor_label);
		panel_left_3.add(panel_left_3_1);
		
		
		panel_left.add(panel_left_1);
		panel_left.add(panel_left_2);
		panel_left.add(panel_left_3);
		
		
		panel_right.setLayout(new GridLayout(4, 1));
//		panel_right.setBackground(Color.blue);
		
		panel_right_inner_1.setLayout(new GridLayout(2,1));
		panel_right_inner_2.setLayout(new GridLayout(2,1));
		
		panel_right.add(enter_gate);
		panel_right.add(panel_right_inner_1);
		
		panel_right.add(exit_gate);
		panel_right.add(panel_right_inner_2);
		
		
		
		frame.add(panel_left);
		frame.add(panel_right);
		
		// ADDING EXIT ON CLOSE
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// SET FRAME TITLE
		frame.setTitle("Museum GUI");
		
		// SET TO VISABLE
		frame.setVisible(true);
		
	}
	
	
	private JLabel createLabel(String labelName , boolean addborder, boolean bold, int size) {
		JLabel newLabel = new JLabel(labelName);
		newLabel.setHorizontalAlignment(JLabel.CENTER);
		
		if(addborder == true) {
			newLabel.setBorder(border);			
		}
		
		if(bold == true) {
			newLabel.setFont(new Font("Serif", Font.BOLD, size));
		}else {
			newLabel.setFont(new Font("Serif", Font.PLAIN, size));
		}
		
		return newLabel;
	}
	
	private JPanel createPanel(int row, int column, boolean addBorder) {
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new GridLayout(row,column));
		
		if(addBorder == true) {
			newPanel.setBorder(border);
		}
		
		return newPanel;
	}
	
	
	public void updateTimeGUI(String time) {
		current_time.setText(time);
	}
	
	public void updateCounterGUI(String counter) {
		counter_status.setText(counter);
	}
	
	public void updateMuseumGUI(String museum) {
		museum_status.setText(museum);
	}
	
	public static void main(String[] args) {
		new GUI();
	}
	
	
	
}
