package museum;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	
	private JFrame frame;
	private JPanel panel;
	
	// All text field
	private JLabel counter_l, museum_l, time_l;
	
	
	public GUI() {
		
		//INITIATE FRAME
		frame = new JFrame();
		counter_l = new JLabel("Counter - Close");
		museum_l = new JLabel("Museum - Close");
		time_l = new JLabel("Time - 00:00");
		
		
		panel = new JPanel();
		
		// SET MARGIN/PADDING
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		// GRID LAYOUT
		panel.setLayout(new GridLayout(0,1));
		
		// ADDING ALL THE CREATED LABEL
		panel.add(museum_l);
		panel.add(counter_l);
		panel.add(time_l);
		
		// ADDING PANEL TO FRAME
		frame.add(panel, BorderLayout.CENTER);
		
		// ADDING EXIT ON CLOSE
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// SET FRAME TITLE
		frame.setTitle("Museum GUI");
		
		
		// SET TO VISABLE
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
//	
//	public static void main(String[] args) {
//		new GUI();
//	}
//	
	
}
