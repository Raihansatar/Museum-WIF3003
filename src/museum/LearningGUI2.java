package museum;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

// TAKEN FROM:
// https://www.youtube.com/watch?v=X5Q-Mecu_64
// 
public class LearningGUI2 {
	
	private JFrame frame;
	private JPanel panel;
	
	// All text field
	private JLabel counter_l, museum_l, time_l;
	private JButton start_btn;
	
	
	public LearningGUI2() {
		
		//INITIATE FRAME
		frame = new JFrame();
		counter_l = new JLabel("Counter - Close");
		museum_l = new JLabel("Museum - Close");
		time_l = new JLabel("Time - 00:00");
		
		start_btn = new JButton("Start");
		start_btn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				start();
			}
		});
		
		
		panel = new JPanel();
		
		// SET MARGIN/PADDING
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		// GRID LAYOUT
		panel.setLayout(new GridLayout(0,1));
		
		// ADDING ALL THE CREATED LABEL
		panel.add(museum_l);
		panel.add(counter_l);
		panel.add(time_l);
		panel.add(start_btn);
		
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
	
	private void start() {
		SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {

			@Override
			protected Boolean doInBackground() throws Exception {
				// TODO Auto-generated method stub
				for(int i=0; i<30; i++) {
					Thread.sleep(100);
					System.out.println("Hello: "+ i);
					
					publish(i);
				}
				
				return true;
			}
			
			

			@Override
			protected void process(List<Integer> chunks) {
				// TODO Auto-generated method stub
//				super.process(chunks);
				
				Integer value = chunks.get(chunks.size()-1);
				
				time_l.setText("Current value:" + value);
				
			}



			@Override
			protected void done() {
				// TODO Auto-generated method stub
//				super.done();
				
				try {
					Boolean status = get();
					museum_l.setText("Completed With Status: "+status);
					System.out.println("Completed With Status: "+status);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};
		
		worker.execute();
	}
	
	
	
	

	
	
	
	
	
	
	
	public static void main(String[] args) {
		new LearningGUI2();
	}
	
}
