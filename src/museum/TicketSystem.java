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
	
	public Ticket[] buy(int number, int timeEnter) {
		Ticket []ticket = museum.buyTicket(number, timeEnter);
		return ticket;
	}

}
