package museum;

import java.util.Random;

public class Entering implements Runnable{

	protected Museum museum;
	protected Random rand = new Random();
	protected Ticket ticket;
	protected int staying;
	
	public Entering(Museum museum, Ticket ticket, int staying) {
		// TODO Auto-generated constructor stub
		this.museum = museum;
		this.ticket = ticket;
		this.staying = staying;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int randomExit = rand.nextInt(2) + 1;
		if(randomExit == 1) {
			museum.enterNorth(this.ticket, staying);	
		}else {
			museum.enterSouth(this.ticket, staying);
		}
		
	}

}
