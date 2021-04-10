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
	protected Lock lock;
	protected boolean NET1, NET2, NET3, NET4, SE1, SE2, SE3, SE4 = false;
	int northGate=0;
//	protected int southGate;
	Random rand = new Random();
	
	public Museum(int maxVisitor ,int totalTicket) {
		// TODO Auto-generated constructor stub
		this.visitor = 0;
		this.maxVisitor = maxVisitor;
		this.ticket = 0;
		this.lock = new ReentrantLock();
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
		
		
		int gate = randomGate(0);
		
		switch (gate) {
		case 0: {
			SE1 = true;
			while(SE1 == false) {
				try {
					System.out.println("Waiting... South gate exceed limit");
					wait();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			break;
		}
		case 1: {
			SE2 = true;
			while(SE2 == false) {
				try {
					System.out.println("Waiting... South gate exceed limit");
					wait();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			break;
		}
		case 2: {
			SE3 = true;
			while(SE3 == false) {
				try {
					System.out.println("Waiting... South gate exceed limit");
					wait();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			break;
		}
		case 3: {
			SE4 = true;
			while(SE4 == false) {
				try {
					System.out.println("Waiting... South gate exceed limit");
					wait();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + gate);
		}
		
		visitor++;
		System.out.print(dateFormat.format(new Date()) + " - ");
		System.out.print("T00" + t.getID() + " entering through Turnsile SET"+gate+". Staying for " + staying + " minutes  \n");
//		System.out.println("Visitor with "+t.getID()+ "  enter the museum South gate at: " + dateFormat.format(new Date()));
//		System.out.println("Total Visitor: " + this.visitor);
		
		switch (gate) {
		case 0: {
			SE1 = false;
			break;
		}
		case 1: {
			SE2 = false;
			break;
		}
		case 2: {
			SE3 = false;
			break;
		}
		case 3: {
			SE4 = false;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + gate);
		}
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
		
		while(this.northGate>3) {
			try {
				System.out.println("Waiting... North gate exceed limit");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		visitor++;
		this.northGate++;
		System.out.print(dateFormat.format(new Date()) + " - ");
		System.out.print("T00" + t.getID() + " entering through Turnsile NET"+this.northGate+". Staying for " + staying + " minutes \n");
//		System.out.println("Visitor with "+t.getID()+ " enter the museum North Gate at: " + dateFormat.format(new Date()));
//		System.out.println("Total Visitor: " + this.visitor);
		this.northGate--;
		notifyAll();
	}
	
	public synchronized void exitEast(Ticket ticket) {
		visitor--;
		System.out.print(dateFormat.format(new Date()) + " - ");
		System.out.print("Ticket T00" + ticket.getID() + " exited through Turnstile EETX ");
		System.out.println("Total Visitor: " + this.visitor);
		notifyAll();
	}
	
	public synchronized void exitWest(Ticket ticket) {
		visitor--;
		System.out.print(dateFormat.format(new Date()) + " - ");
		System.out.print("Ticket T00" + ticket.getID() + " exited through Turnstile EWTX ");
		System.out.println("Total Visitor: " + this.visitor);
		notifyAll();
	}

	public synchronized Ticket[] buyTicket(int number) {

		
		if(ticket >= this.totalTicket) {
			try {
				System.out.println("Out of ticket." + Thread.currentThread().getName());
				Thread.currentThread().interrupt();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}else {
//			System.out.println(Thread.currentThread().getName() + " bought " + number + " ticket");
			Ticket[] t = new Ticket[number];
			System.out.print(dateFormat.format(new Date()) + " - ");
			for (int i = 0; i < number; i++) {
				
//				System.out.println("Current ticket: " + this.ticket);
				System.out.print("T00" + this.ticket + " ");
				t[i] = new Ticket(this.ticket);
				this.ticket++;
			}
			System.out.println("SOLD");
			return t;
		}
	}
	
	public int randomGate(int type) {
		
		int gateID;
		if(type == 0) { //southGate
			gateID  = rand.nextInt(4);
		}else { //northgate
			gateID = 0;
		}
		
		return gateID;
	}
}
