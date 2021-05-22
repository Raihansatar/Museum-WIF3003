package museum;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	
	// Other components	
	private JLabel museum_status = new JLabel("Museum is Closed");
	private JLabel counter_status = new JLabel("Counter is Closed");
	private JLabel current_time = new JLabel("Time: 00:00");
	
	public GUI() {
		
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,02));
		panel.setLayout(new GridLayout(0,1));
		
		panel.add(museum_status);
		panel.add(counter_status);
		panel.add(current_time);
		
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
	
	public void updateTimeGUI(String time) {
		current_time.setText(time);
	}
	
	public void updateCounterGUI(String counter) {
		counter_status.setText(counter);
	}
	
	public void updateMuseumGUI(String museum) {
		museum_status.setText(museum);
	}
	
	
}
