package museum;

import java.util.Random;
import java.util.Scanner;

public class TicketSystem {
	
	protected Museum museum;
	protected Ticket t[];
	Random rand  = new Random();
	Scanner scan = new Scanner(System.in);
	
	public TicketSystem(Museum museum) {
		// TODO Auto-generated constructor stub
		this.museum = museum;
	}
	
	public Ticket[] buyTicket() {
		System.out.print(Thread.currentThread().getName() + " - How may ticket you want to buy? : \n");
		int number = scan.nextInt();
		int timeEnter = (int) (rand.nextInt(61200 - (int)museum.getTimer().getTime()) + museum.getTimer().getTime());
		Ticket []ticket = buy(number, timeEnter);
		return ticket;
	}
	
	public Ticket[] buy(int number, int timeEnter) {
        
		Ticket []ticket = museum.buyTicket(number, timeEnter);
		return ticket;
	}

}
