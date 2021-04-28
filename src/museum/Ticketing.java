package museum;

import java.util.Random;
import java.util.Scanner;

public class Ticketing implements Runnable{

	protected Museum museum;
	protected Ticket t[];
	protected TicketSystem ticketSystem;
	Random rand  = new Random();
	Scanner scan = new Scanner(System.in);
	
	public Ticketing(Museum museum) {
		// TODO Auto-generated constructor stub
		this.museum = museum;
		this.ticketSystem = new TicketSystem(museum);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		this.t = ticketSystem.buy(rand.nextInt(4) + 1);
		//	uncomment for automate random number of ticket buy
		
		//	this.t = ticketSystem.buyTicket(); 
		//	uncomment for manual number of ticket buy
		
		if(this.t != null) {
			Thread [] th = new Thread[t.length];
			for (int i = 0; i < t.length; i++) {
				th[i] = new Thread(new Visitor(museum, t[i]));
			}
			for (int i = 0; i < t.length; i++) {
				th[i].start();
			}
		}
		
	}

}
