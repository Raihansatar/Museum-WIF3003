package museum;

import java.util.Random;

public class Ticketing implements Runnable{

	protected Museum museum;
	protected Ticket t[];
//	protected Entering entering;
	Random rand  = new Random();
	
	public Ticketing(Museum museum) {
		// TODO Auto-generated constructor stub
		this.museum = museum;
//		this.entering = entering;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		this.t = museum.buyTicket(rand.nextInt(2) + 1); // array of tickets
		
		this.t = buy(rand.nextInt(2) + 1); // array of tickets
		
		
		
		if(this.t != null) {
			Thread [] th = new Thread[t.length];
//			System.out.println("Length " + t.length);
			for (int i = 0; i < t.length; i++) {
//				System.out.println("ID: -- " + t[i].getID());
				th[i] = new Thread(new Visitor(museum, t[i]));
			}
//			
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
