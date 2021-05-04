package museum;

import java.util.Random;
import java.util.Scanner;

public class Ticketing implements Runnable{
// process of buy ticket and create visitor based on the number of ticket
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
		
//		int timeEnter = rand.nextInt(67800 - 32400) + 32400;
//		int timeEnter = rand.nextInt(36000 - 32400) + 32400;
		int timeEnter = (int) (rand.nextInt(61200 - (int)museum.getTimer().getTime()) + museum.getTimer().getTime());
		
		//generate same entering time per who buy ticket
		this.t = ticketSystem.buy(rand.nextInt(4) + 1, timeEnter);
		//	uncomment for automate random number of ticket buy
		
			//this.t = ticketSystem.buyTicket(); 
		//	uncomment for manual number of ticket buy
		
		if(this.t != null) {
			Thread [] th = new Thread[t.length];
                        
                        //Set same entrance for ticket groups
                        int entrance = rand.nextInt(2);
                        
			for (int i = 0; i < t.length; i++) {
				th[i] = new Thread(new Visitor(museum, t[i], entrance));
			}
			for (int i = 0; i < t.length; i++) {
				th[i].start();
			}
		}
		
	}

}
