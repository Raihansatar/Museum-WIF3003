package museum;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUI{
	
	// Other componens
	private JLabel current_time;
	private JLabel museum_status;
	private JLabel counter_status;
	
	private JLabel remaining_tickets;
	private JLabel sold_tickets;
	private JLabel ticket_holder;
	
	private JLabel max_visitor;
	private JLabel current_visitor;
	
	private JLabel[] north_gates = new JLabel[4];
	private JLabel[] south_gates = new JLabel[4];
	private JLabel[] east_gates = new JLabel[4];
	private JLabel[] west_gates = new JLabel[4];
	

	public GUI() {
		
		JFrame frame = new JFrame();
		frame.setSize(750, 500);
		frame.setLayout(new GridLayout(1,2));
								
							// createLabel(Label text, add border, bold text, text size)
		current_time 		= createLabel("TIME: 00:00", false, true, 30);
		museum_status 		= createLabel("MUSEUM IS CLOSED", true, true, 12);
		museum_status.setForeground(Color.WHITE);
		museum_status.setBackground(Color.RED);
		museum_status.setOpaque(true);
		
		counter_status 		= createLabel("COUNTER IS CLOSED", true, true, 12);
		counter_status.setForeground(Color.WHITE);
		counter_status.setBackground(Color.RED);
		counter_status.setOpaque(true);
		
		JLabel ticket_label = createLabel("Tickets", false, true, 20);
		remaining_tickets 	= createLabel("XXX", true, false, 12);
		sold_tickets 		= createLabel("0", true, false, 12);
		ticket_holder 		= createLabel("insert ticket holder here", false, false, 12);

		JLabel visitor_label= createLabel("Visitor Count", false, true, 20);
		max_visitor 		= createLabel("XXX", true, false, 12);
		current_visitor 	= createLabel("0", true, false, 12);
		current_visitor.setBackground(Color.YELLOW);
		
		JLabel enter_gate 	= createLabel("Enter Gate", false, true, 30);
		JLabel exit_gate 	= createLabel("Exit Gate", false, true, 30);
		for(int i=0; i<4; i++) {
			north_gates[i] = createLabel("T"+(i+1), true, false, 12);
			south_gates[i] = createLabel("T"+(i+1), true, false, 12);
			east_gates[i] = createLabel("T"+(i+1), true, false, 12);
			west_gates[i] = createLabel("T"+(i+1), true, false, 12);
		}
		
		Border borderMargin = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		// LEFT SIDE PANEL		
						
						// createPanel(row, colum, x-margin, y-margin , add border)
		JPanel panel_left = createPanel(3, 1, 0, 0, true);
		
		JPanel panel_left_1 = createPanel(2, 1, 0, 0, true);
		JPanel panel_left_1_1 = createPanel(1, 2, 10, 10, false);
		
		panel_left_1_1.setBorder(borderMargin);
		panel_left_1_1.add(museum_status);
		panel_left_1_1.add(counter_status);
		
		panel_left_1.add(current_time);
		panel_left_1.add(panel_left_1_1);
		
		JPanel panel_left_2 = createPanel(3, 1, 0, 0, true);
		JPanel panel_left_2_1 = createPanel(1, 2, 10, 10, false);
		
		panel_left_2_1.setBorder(borderMargin);
		panel_left_2_1.add(remaining_tickets);
		panel_left_2_1.add(sold_tickets);
		
		panel_left_2.add(ticket_label);
		panel_left_2.add(panel_left_2_1);
		panel_left_2.add(ticket_holder);
		
		
		JPanel panel_left_3 = createPanel(2, 1, 0, 0, true);
		JPanel panel_left_3_1 = createPanel(1, 2, 10, 10, false);
		
		panel_left_3_1.setBorder(borderMargin);
		panel_left_3_1.add(max_visitor);
		panel_left_3_1.add(current_visitor);
		
		panel_left_3.add(visitor_label);
		panel_left_3.add(panel_left_3_1);
		
		
		panel_left.add(panel_left_1);
		panel_left.add(panel_left_2);
		panel_left.add(panel_left_3);
		
		
		// RIGHT PANEL
		JPanel panel_right = createPanel(2, 1, 0, 0, true);
		
		// NORTH AND SOUTH PANEL
		JPanel panel_right_1 = createPanel(2, 1, 0, 0, true);
		JPanel panel_right_1_1 = createPanel(2, 2, 0, 0, false);
		
		
		// NORTH
		JPanel panel_right_1_1_north = createPanel(2, 2, 5, 5, true);
		panel_right_1_1_north.setBorder(borderMargin);
		
		JPanel panel_right_1_1_north_T1 = createPanel(1, 2, 0, 0, false);
		panel_right_1_1_north_T1.add(createLabelAlignRight("T1  ", false, false, 12));
		panel_right_1_1_north_T1.add(north_gates[0]);
		
		JPanel panel_right_1_1_north_T2 = createPanel(1, 2, 0, 0, false);
		panel_right_1_1_north_T2.add(createLabelAlignRight("T2  ", false, false, 12));
		panel_right_1_1_north_T2.add(north_gates[1]);
		
		JPanel panel_right_1_1_north_T3 = createPanel(1, 2, 0, 0, false);
		panel_right_1_1_north_T3.add(createLabelAlignRight("T3  ", false, false, 12));
		panel_right_1_1_north_T3.add(north_gates[2]);
		
		JPanel panel_right_1_1_north_T4 = createPanel(1, 2, 0, 0, false);
		panel_right_1_1_north_T4.add(createLabelAlignRight("T4  ", false, false, 12));
		panel_right_1_1_north_T4.add(north_gates[3]);
		
		panel_right_1_1_north.add(panel_right_1_1_north_T1);
		panel_right_1_1_north.add(panel_right_1_1_north_T2);
		panel_right_1_1_north.add(panel_right_1_1_north_T3);
		panel_right_1_1_north.add(panel_right_1_1_north_T4);
		
		
		// SOUTH
		JPanel panel_right_1_1_south = createPanel(2, 2, 5, 5, true);
		panel_right_1_1_south.setBorder(borderMargin);
		
		JPanel panel_right_1_1_south_T1 = createPanel(1, 2, 0, 0, false);
		panel_right_1_1_south_T1.add(createLabelAlignRight("T1  ", false, false, 12));
		panel_right_1_1_south_T1.add(south_gates[0]);
		
		JPanel panel_right_1_1_south_T2 = createPanel(1, 2, 0, 0, false);
		panel_right_1_1_south_T2.add(createLabelAlignRight("T2  ", false, false, 12));
		panel_right_1_1_south_T2.add(south_gates[1]);
		
		JPanel panel_right_1_1_south_T3 = createPanel(1, 2, 0, 0, false);
		panel_right_1_1_south_T3.add(createLabelAlignRight("T3  ", false, false, 12));
		panel_right_1_1_south_T3.add(south_gates[2]);
		
		JPanel panel_right_1_1_south_T4 = createPanel(1, 2, 0, 0, false);
		panel_right_1_1_south_T4.add(createLabelAlignRight("T4  ", false, false, 12));
		panel_right_1_1_south_T4.add(south_gates[3]);
		
		panel_right_1_1_south.add(panel_right_1_1_south_T1);
		panel_right_1_1_south.add(panel_right_1_1_south_T2);
		panel_right_1_1_south.add(panel_right_1_1_south_T3);
		panel_right_1_1_south.add(panel_right_1_1_south_T4);
		
		
		// ADDING NORTH AND SOUTH PANEL
		panel_right_1_1.add(createLabel("North Gate", false, true, 20));
		panel_right_1_1.add(createLabel("South Gate", false, true, 20));
		panel_right_1_1.add(panel_right_1_1_north);
		panel_right_1_1.add(panel_right_1_1_south);
		
		// ADDING THE ENTER GATE PANEL
		panel_right_1.add(enter_gate);
		panel_right_1.add(panel_right_1_1);
		
		
		
		// EAST AND WEST PANEL
		JPanel panel_right_2 = createPanel(2, 1, 0, 0, true);
		JPanel panel_right_2_1 = createPanel(2, 2, 0, 0, false);
		
		// EAST
		JPanel panel_right_2_1_east = createPanel(2, 2, 5, 5, true);
		panel_right_2_1_east.setBorder(borderMargin);
		
		JPanel panel_right_2_1_east_T1 = createPanel(1, 2, 0, 0, false);
		panel_right_2_1_east_T1.add(createLabelAlignRight("T1  ", false, false, 12));
		panel_right_2_1_east_T1.add(east_gates[0]);
		
		JPanel panel_right_2_1_east_T2 = createPanel(1, 2, 0, 0, false);
		panel_right_2_1_east_T2.add(createLabelAlignRight("T2  ", false, false, 12));
		panel_right_2_1_east_T2.add(east_gates[1]);
		
		JPanel panel_right_2_1_east_T3 = createPanel(1, 2, 0, 0, false);
		panel_right_2_1_east_T3.add(createLabelAlignRight("T3  ", false, false, 12));
		panel_right_2_1_east_T3.add(east_gates[2]);
		
		JPanel panel_right_2_1_east_T4 = createPanel(1, 2, 0, 0, false);
		panel_right_2_1_east_T4.add(createLabelAlignRight("T4  ", false, false, 12));
		panel_right_2_1_east_T4.add(east_gates[3]);
		
		panel_right_2_1_east.add(panel_right_2_1_east_T1);
		panel_right_2_1_east.add(panel_right_2_1_east_T2);
		panel_right_2_1_east.add(panel_right_2_1_east_T3);
		panel_right_2_1_east.add(panel_right_2_1_east_T4);
		
		
		// WEST
		JPanel panel_right_2_1_west = createPanel(2, 2, 5, 5, true);
		panel_right_2_1_west.setBorder(borderMargin);
		
		JPanel panel_right_2_1_west_T1 = createPanel(1, 2, 0, 0, false);
		panel_right_2_1_west_T1.add(createLabelAlignRight("T1  ", false, false, 12));
		panel_right_2_1_west_T1.add(west_gates[0]);
		
		JPanel panel_right_2_1_west_T2 = createPanel(1, 2, 0, 0, false);
		panel_right_2_1_west_T2.add(createLabelAlignRight("T2  ", false, false, 12));
		panel_right_2_1_west_T2.add(west_gates[1]);
		
		JPanel panel_right_2_1_west_T3 = createPanel(1, 2, 0, 0, false);
		panel_right_2_1_west_T3.add(createLabelAlignRight("T3  ", false, false, 12));
		panel_right_2_1_west_T3.add(west_gates[2]);
		
		JPanel panel_right_2_1_west_T4 = createPanel(1, 2, 0, 0, false);
		panel_right_2_1_west_T4.add(createLabelAlignRight("T4  ", false, false, 12));
		panel_right_2_1_west_T4.add(west_gates[3]);
		
		panel_right_2_1_west.add(panel_right_2_1_west_T1);
		panel_right_2_1_west.add(panel_right_2_1_west_T2);
		panel_right_2_1_west.add(panel_right_2_1_west_T3);
		panel_right_2_1_west.add(panel_right_2_1_west_T4);
		
		
		// ADDING EAST AND WEST PANEL
		panel_right_2_1.add(createLabel("East Gate", false, true, 20));
		panel_right_2_1.add(createLabel("West Gate", false, true, 20));
		panel_right_2_1.add(panel_right_2_1_east);
		panel_right_2_1.add(panel_right_2_1_west);

		// ADDIING THE EXIT GATE PANEL
		panel_right_2.add(exit_gate);
		panel_right_2.add(panel_right_2_1);

		
		
		// ADDING THE EXIT AND ENTER GATE PANEL
		panel_right.add(panel_right_1);
		panel_right.add(panel_right_2);
		
		
		// ADDING THE LEFT AND RIGHT PANEL
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
			newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));			
		}
		
		if(bold == true) {
			newLabel.setFont(new Font("Serif", Font.BOLD, size));
		}else {
			newLabel.setFont(new Font("Serif", Font.PLAIN, size));
		}
		return newLabel;
	}
	
	private JLabel createLabelAlignRight(String labelName , boolean addborder, boolean bold, int size) {
		JLabel newLabel = new JLabel(labelName);
		newLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		if(addborder == true) {
			newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));			
		}
		
		if(bold == true) {
			newLabel.setFont(new Font("Serif", Font.BOLD, size));
		}else {
			newLabel.setFont(new Font("Serif", Font.PLAIN, size));
		}
		
		return newLabel;
	}
	
	private JPanel createPanel(int row, int column, int mx, int my, boolean addBorderLine) {
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new GridLayout(row, column, mx, my));
		
		if(addBorderLine == true) {
			newPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		}
		
		return newPanel;
	}
	
	
	public void updateTimeGUI(String time) {
		current_time.setText(time);
	}
	
	public void updateCounterGUI(String counter, boolean isOpen) {
		counter_status.setText(counter);
		if(isOpen == true) {
			counter_status.setForeground(Color.BLACK);
			counter_status.setBackground(Color.GREEN);
		}else {
			counter_status.setForeground(Color.WHITE);
			counter_status.setBackground(Color.RED);
		}
	}
	
	public void updateMuseumGUI(String museum, boolean isOpen) {
		museum_status.setText(museum);
		if(isOpen == true) {
			museum_status.setForeground(Color.BLACK);
			museum_status.setBackground(Color.GREEN);
		}else {
			museum_status.setForeground(Color.WHITE);
			museum_status.setBackground(Color.RED);
		}
	}
	
	public void updateRemainingTickets(String tickets_remaining, boolean isAvailable) {
		remaining_tickets.setText(tickets_remaining);
		
		if(isAvailable == false) {
			remaining_tickets.setForeground(Color.WHITE);
			remaining_tickets.setBackground(Color.RED);
			remaining_tickets.setOpaque(true);
		}
	}
	
	public void updateSoldTickets(String tickets) {
		sold_tickets.setText(tickets);
	}
	
	public void updateTicketHolder(String holder) {
		ticket_holder.setText(holder);
	}
	
	public void updateMaxVisitor(String visitors) {
		max_visitor.setText(visitors);
	}
	
	public void updateCurrentVisitor(String visitor_count, boolean isFull) {
		current_visitor.setText(visitor_count);
		
		if(isFull) {
			current_visitor.setOpaque(true);
		}else {
			current_visitor.setOpaque(false);
		}
	}
	
	public void updateNorthGate(int index, String ticket) {
		north_gates[index].setText(ticket);
	}
	
	public void updateSouthGate(int index, String ticket) {
		south_gates[index].setText(ticket);
	}
	
	public void updateEastGate(int index, String ticket) {
		east_gates[index].setText(ticket);
	}
	
	public void updateWestGate(int index, String ticket) {
		west_gates[index].setText(ticket);
	}
	
//	public static void main(String[] args) {
//		new GUI();
//	}
	
	
	
}
