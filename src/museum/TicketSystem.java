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
	
	public synchronized Ticket[] buyTicket() { // for better visual in console only, actually no need to synchronized
		System.out.print(Thread.currentThread().getName() + " - How may ticket you want to buy? : \n");
		return buy(scan.nextInt());
	}
	
	public Ticket[] buy(int number) {
		Ticket []ticket = museum.buyTicket(number);
		return ticket;
	}

}
