package museum;

import java.util.Random;

public class Visitor implements Runnable{

	protected Museum museum;
	protected Random rand = new Random();
	protected Ticket ticket;
	protected int staying;
	
	public Visitor(Museum museum, Ticket ticket) {
		// TODO Auto-generated constructor stub
		this.museum = museum;
		this.ticket = ticket;
		this.staying = rand.nextInt(10000) + 1000;
		
	}
	
	@Override
	public void run() {
		
		this.staying = rand.nextInt(10000) + 1000; //random staying time
		
		// before enter, visitor need to check the enter time on the ticket
		// here code to check enter time should be here
		
		int random = rand.nextInt(2); // randomly assigned gate to visitor to enter
		if(random == 0) {
			this.museum.enterNorth(this.ticket, staying);
		}else {
			this.museum.enterSouth(this.ticket, staying);
		}
		
		
		// here can put code to check museum closing time and kick the visitor
		try {
			Thread.sleep(this.staying); // sleep the thread to visualised staying time
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		random = rand.nextInt(2); // randomly assigned gate to visitor to exit
		if(random == 0) {
			this.museum.exitEast(this.ticket);
		}else {
			this.museum.exitWest(this.ticket);
		}
		
		
	}
	

}
