package museum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Museum {

	protected int visitor;
	protected int maxVisitor;
	protected int ticket;
	protected int totalTicket;
	protected DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	protected boolean[] NET = {false, false, false, false};
	protected boolean[] SET = {false, false, false, false};
	protected boolean[] EET = {false, false, false, false};
	protected boolean[] WET = {false, false, false, false};
	
	Random rand = new Random();
	
	public Museum(int maxVisitor ,int totalTicket) {
		// TODO Auto-generated constructor stub
		this.visitor = 0;
		this.maxVisitor = maxVisitor;
		this.ticket = 0;
		this.totalTicket = totalTicket;
	}
	
	public synchronized void enterSouth(Ticket t, int staying) {
		while(this.visitor > this.maxVisitor) {
			try {
				System.out.println("Waiting... Museum exceed limit");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		int turnstiles = rand.nextInt(4);
		
		while(SET[turnstiles] == true) {
			try {
				System.out.println("Waiting... Queue turnstiles SET" + turnstiles);
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		SET[turnstiles] = true;
		// sleep
		visitor++;
		System.out.print(dateFormat.format(new Date()) + " - ");
		System.out.print("T00" + t.getID() + " entering through Turnsile SET"+ turnstiles +". Staying for " + staying + " minutes  \n");
		SET[turnstiles] = false;
				
		notifyAll();
	}
	
	public synchronized void enterNorth(Ticket t, int staying) {
		while(this.visitor > this.maxVisitor) {
			try {
				System.out.println("Waiting... Museum exceed limit");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		int turnstiles = rand.nextInt(4);
		while(NET[turnstiles] == true) {
			try {
				System.out.println("Waiting... Queue turnstiles NET" + turnstiles);
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		NET[turnstiles] = true;
		
		visitor++;
		System.out.print(dateFormat.format(new Date()) + " - ");
		System.out.print("T00" + t.getID() + " entering through Turnsile NET"+turnstiles+". Staying for " + staying + " minutes \n");
		
		NET[turnstiles] = false;
		notifyAll();
	}
	
	public synchronized void exitEast(Ticket ticket) {
		int turnstiles = rand.nextInt(4);
		while(EET[turnstiles] == true) {
			try {
				System.out.println("Waiting... Queue turnstiles EET" + turnstiles);
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		EET[turnstiles] = true;
		
		visitor--;
		System.out.print(dateFormat.format(new Date()) + " - ");
		System.out.print("Ticket T00" + ticket.getID() + " exited through Turnstile EET" + turnstiles);
		System.out.println("  Total Visitor: " + this.visitor);
		EET[turnstiles] = false;
		
		notifyAll();
	}
	
	public synchronized void exitWest(Ticket ticket) {
		int turnstiles = rand.nextInt(4);
		while(WET[turnstiles] == true) {
			try {
				System.out.println("Waiting... Queue turnstiles EET" + turnstiles);
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		WET[turnstiles] = true;
		
		visitor--;
		System.out.print(dateFormat.format(new Date()) + " - ");
		System.out.print("Ticket T00" + ticket.getID() + " exited through Turnstile EWT" + turnstiles);
		System.out.println("  Total Visitor: " + this.visitor);
		WET[turnstiles] = false;
		
		notifyAll();
	}

	public synchronized Ticket[] buyTicket(int number) {

		if(ticket > this.totalTicket) {
			try {
				System.out.println("Out of ticket." + Thread.currentThread().getName());
				Thread.currentThread().interrupt();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}else {
			Ticket[] ticket = new Ticket[number];
			System.out.print(dateFormat.format(new Date()) + " - ");
			for (int i = 0; i < number; i++) {
				
				System.out.print("T00" + this.ticket + " ");
				ticket[i] = new Ticket(this.ticket);
				this.ticket++;
			}
			System.out.println("SOLD");
			return ticket;
		}
	}
}
