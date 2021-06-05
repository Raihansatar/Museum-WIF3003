package museum;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//	TAKEN FROM:
//	https://www.youtube.com/watch?v=5o3fMLPY7qY
//

public class LearningGUI implements ActionListener {
	
	public int count = 0;
	
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private JButton button;
	
	public LearningGUI(){
		
		//	CREATE A FRAME(window)
		frame = new JFrame();
		
		//	CREATING A LABEL
		label = new JLabel("number of clicks: 0");
		
		//	CREATING A BUTTON
		button = new JButton("Click Me");
		button.addActionListener(this);
		
		
		
		//	LAYOUT
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		panel.add(label);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Museum GUI");
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		count++;
		label.setText("number of clicks: "+count);
		
	}
	
	
	public static void main(String[] args) {
		new LearningGUI();
	}

		
}
