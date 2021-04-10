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
		
		int random = rand.nextInt(2);
		if(random == 0) {
			this.museum.enterNorth(this.ticket, staying);
		}else {
			this.museum.enterSouth(this.ticket, staying);
		}
		
		try {
			Thread.sleep(this.staying); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		random = rand.nextInt(2);
		if(random == 0) {
			this.museum.exitEast(this.ticket);
		}else {
			this.museum.exitWest(this.ticket);
		}
		
		
	}
	

}
