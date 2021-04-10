package museum;

import java.util.Random;

public class Leaving implements Runnable{

	protected Museum museum;
	protected Random rand = new Random();
	protected Ticket ticket;
	
	public Leaving(Museum museum, Ticket ticket) {
		// TODO Auto-generated constructor stub
		this.museum = museum;
		this.ticket = ticket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int randomExit = rand.nextInt(2) + 1;
		if(randomExit == 1) {
			museum.exitEast(ticket);	
		}else {
			museum.exitWest(ticket);
		}
	}

}
