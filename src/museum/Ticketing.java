package museum;

import java.util.Random;
import java.util.Scanner;

public class Ticketing implements Runnable{

	protected Museum museum;
	protected Ticket t[];
	protected TicketSystem ticketSystem;
	Random rand  = new Random();
	Scanner scan = new Scanner(System.in);
	
	public Ticketing(Museum museum, TicketSystem ticketSystem) {
		// TODO Auto-generated constructor stub
		this.museum = museum;
		this.ticketSystem = ticketSystem;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
//			System.out.print(Thread.currentThread().getName() + " - How may ticket you want to buy? : \n");
//			this.t = buy(scan.nextInt());			
		
		this.t = buy(rand.nextInt(4) + 1); // array of tickets

//		this.t = ticketSystem.buyTicket();
		
		
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
	
	public Ticket[] buy(int number) {
		Ticket []ticket = museum.buyTicket(number);
		return ticket;
	}
	
	

}
