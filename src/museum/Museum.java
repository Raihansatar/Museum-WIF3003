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
        private Timer timer;
	
	public Museum(int maxVisitor ,int totalTicket, Timer timer) {
		// TODO Auto-generated constructor stub
		this.visitor = 0;
		this.maxVisitor = maxVisitor;
		this.ticket = 1;
		this.totalTicket = totalTicket;
        this.timer = timer;
	}
	
	// enter south gate
	public synchronized void enterSouth(Ticket t, int staying) {
                
                
		while(this.visitor > this.maxVisitor) { // check if current visitor more that max visitor allowed in the museum
			try {
				System.out.println("Waiting... Museum exceed limit");
				wait(); // wait until museum not occupied
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		int turnstiles = rand.nextInt(4); // set random turnstiles for wisitors to enter the museum
		
		while(SET[turnstiles] == true) { // if true means that turnstile is currently in used
			try {
				System.out.println("Waiting... Queue turnstiles SET" + (turnstiles + 1));
				wait(); // wait until turnstile is not in use
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		SET[turnstiles] = true; // set turnstile to true (in use)
		
		
		visitor++; // increase the number of visitor in museum
                System.out.print(timer.toString() + " - ");
		System.out.print(t.getID() + " with time " + t.getTicketTime()+ "  entering through Turnsile SET"+ (turnstiles + 1) +". Staying for " + staying + " minutes  \n");
		SET[turnstiles] = false; // set turnstile to free
				
		notifyAll();
	}
	
	// same with above
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
	            System.out.println("Waiting... Queue turnstiles NET" + (turnstiles + 1));
	            wait();
	        } catch (Exception e) {
                // TODO: handle exception
	        }
		}
		NET[turnstiles] = true;
		
		visitor++;
                System.out.print(timer.toString() + " - ");
		System.out.print(t.getID() + " with time " + t.getTicketTime()+ " entering through Turnsile NET"+(turnstiles + 1) +". Staying for " + staying + " minutes \n");
		
		NET[turnstiles] = false;
		notifyAll();
	}
	
	// same with above
	public synchronized void exitEast(Ticket ticket) {
		int turnstiles = rand.nextInt(4);
		
		while(EET[turnstiles] == true) {
			try {
				System.out.println("Waiting... Queue turnstiles EET" + (turnstiles + 1) );
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		EET[turnstiles] = true;
		
		visitor--;
                System.out.print(timer.toString() + " - ");
		System.out.print("Ticket " + ticket.getID() + " exited through Turnstile EET" + (turnstiles + 1));
		System.out.println("  Total Visitor: " + this.visitor);
		EET[turnstiles] = false;
		
		notifyAll();
	}
	
	// same with above
	public synchronized void exitWest(Ticket ticket) {
		int turnstiles = rand.nextInt(4);
		while(WET[turnstiles] == true) {
			try {
				System.out.println("Waiting... Queue turnstiles EET" + (turnstiles + 1));
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		WET[turnstiles] = true;
		
		visitor--;
	
                System.out.print(timer.toString() + " - ");
		System.out.print("Ticket " + ticket.getID() + " exited through Turnstile EWT" + (turnstiles + 1));
		System.out.println("  Total Visitor: " + this.visitor);
		WET[turnstiles] = false;
		
		notifyAll();
	}

	public synchronized Ticket[] buyTicket(int number, int timeEnter) {
                
        //check if between 8:00am and 5:00pm
        while(timer.getTime()<28800 || timer.getTime()>61200){
            System.out.println("Time is "+timer.toString()+", ticket counter not open");
	    if(timer.getTime()>61200) {
            	return null;
            }
        }
        
		if(ticket > this.totalTicket) { // check if ticket still available
			try {
				System.out.println(timer.toString() + " - Sorry, out of ticket. " + Thread.currentThread().getName());
				Thread.currentThread().interrupt(); // end the thread since out of ticket
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null; // for error handling
		}else {
			Ticket[] ticket = new Ticket[number]; // set array of number of tickets
            System.out.print(timer.toString() + " - ");
			for (int i = 0; i < number; i++) {
				
				ticket[i] = new Ticket(this.ticket, timeEnter); // create object ticket
				System.out.print(ticket[i].getID() + " (" + ticket[i].getTicketTime() +  ") ");
				this.ticket++; // basically this is decrease number of the tickets available in the museum
			}
			System.out.println("SOLD");
			return ticket;
		}
	}

	public Timer getTimer() {
		return this.timer;
	}
}
