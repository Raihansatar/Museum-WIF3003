package museum;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIInput implements ActionListener{
	

	JFrame frame = new JFrame();
	private JButton submitBtn = new JButton("Run Museum");
	
	private JTextField hourField = new JTextField();
	private JTextField minutesField = new JTextField();
	private JTextField maxVisitorField = new JTextField();
	private JTextField maxTicketField = new JTextField();
	private JTextField numVisitorField = new JTextField();
	
	public GUIInput(){
		
		
		frame.setLayout(new GridLayout(0,1));
		JPanel mainPanel = createPanel(0, 1, 0, 0, false);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(30,70,30,70));
		
		
		JPanel timePanelA = createPanel(1, 2, 10, 5, false);
		timePanelA.add(createLabel("Hour", false, true, 12));
		timePanelA.add(createLabel("Minutes", false, true, 12));
		JPanel timePanelB = createPanel(1, 2, 10, 5, false);
		timePanelB.add(hourField);
		timePanelB.add(minutesField);
		
		
		JLabel title = createLabel("COVID-19 Museum Simulator", false, true, 20);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		
		submitBtn.addActionListener(this);
		
		mainPanel.add(title);
		mainPanel.add(createPanel(0,1, 0, 0, false)); //spacer
		mainPanel.add(timePanelA);
		mainPanel.add(timePanelB);
		
		mainPanel.add(createLabel("Maximum Visitors", false, true, 12));
		mainPanel.add(maxVisitorField);
		
		mainPanel.add(createLabel("Maximum Tickets", false, true, 12));
		mainPanel.add(maxTicketField);
		
		mainPanel.add(createLabel("Number of Visitors", false, true, 12));
		mainPanel.add(numVisitorField);
				
		mainPanel.add(createPanel(0,1, 0, 0, false)); //spacer
		mainPanel.add(submitBtn);
		frame.add(mainPanel);
		
		
		//Pack the frame
		frame.pack();
		
		// ADDING EXIT ON CLOSE
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// SET FRAME TITLE
		frame.setTitle("Museum GUI Input");
		
		// SET TO VISABLE
		frame.setVisible(true);
		
		
		
	}
	
	private JPanel createPanel(int row, int column, int mx, int my, boolean addBorderLine) {
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new GridLayout(row, column, mx, my));
		
		if(addBorderLine == true) {
			newPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		}
		return newPanel;
	}
	
	private JLabel createLabel(String labelName , boolean addborder, boolean bold, int size) {
		JLabel newLabel = new JLabel(labelName);
		newLabel.setVerticalAlignment(JLabel.BOTTOM);
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitBtn) {
			submitBtn.setEnabled(false);
			
			hourField.setEditable(false);
			minutesField.setEditable(false);
			maxTicketField.setEditable(false);
			maxVisitorField.setEditable(false);
			numVisitorField.setEditable(false);
			
			
			frame.dispose();
			
//			START DRIVER HERE
			
			GUI gui = new GUI();
            Timer timer = new Timer(gui, Integer.parseInt(hourField.getText()), Integer.parseInt(minutesField.getText()));
            Thread tt = new Thread(timer);
            
            gui.updateRemainingTickets(maxTicketField.getText()+" Remaining", true);
            gui.updateMaxVisitor(maxVisitorField.getText()+" Max Visitor");
            
            
            tt.setName("Timer thread");
            
            //	create museum object with parameter ( maxVisitor, total ticket available, timer thread)
            Museum museum = new Museum(Integer.parseInt(maxVisitorField.getText()), Integer.parseInt(maxTicketField.getText()), timer, gui);

            //start timer
            tt.start();
            
            // create an anonymous runnable for the purpose of buying tickets 
            Thread ticketBuyer = new Thread(new Runnable() {

				@Override
				public void run() {
					ExecutorService pool = Executors.newFixedThreadPool(Integer.parseInt(numVisitorField.getText()));
					Random rand = new Random();
			        for (int i = 0; i < Integer.parseInt(numVisitorField.getText()); i++) {
				    	try {
				                Thread.sleep(rand.nextInt(2400) + 600);
				        } catch (Exception f) {
				                  // TODO: handle exception
				        }
			            pool.execute(new Ticketing(museum));
			        }
				
			        pool.shutdown();   
					
				}
            	
            });
            
            ticketBuyer.start();
            
            
		}
		
	}
	
	
}
