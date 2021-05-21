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
		
		int timeEnter;
		
<<<<<<< HEAD
		if (museum.getTimer().getTime() < 32400) { //enter after the museum opens
			timeEnter = (rand.nextInt(64801 - museum.getTimer().getTime()) + 32400);
		} else if(museum.getTimer().getTime() > 32400 && museum.getTimer().getTime() < 64800){
			do{
				timeEnter = (rand.nextInt(64801 - museum.getTimer().getTime()) + museum.getTimer().getTime());
			}while(timeEnter>64800); //enter before museum closes
		} else {
			timeEnter = 0;
=======
		
		boolean timerFlag = true;
		while(true){
			if(museum.getTimer().isCounterOpen()) {
		      	break;
			}
		    if(timerFlag) {
		    	System.out.println("Time is "+museum.getTimer().toString()+" ticket counter not open ["+Thread.currentThread().getName()+"]");
		      	timerFlag=false;
		    }
		}
		
		// what is this?
		
		//less then 9am
		if ((int)museum.getTimer().getTime() < museum.getTimer().getMuseumOpeningTime()) {
			
			// random 5pm - get timer
			timeEnter = (int) (rand.nextInt(61200 - (int)museum.getTimer().getTime()) + 32400);
			
		} else {
			
			do {
				timeEnter = (int) (rand.nextInt(61200 - (int)museum.getTimer().getTime()) + museum.getTimer().getTime());				
			}while(timeEnter < museum.getTimer().getMuseumClosingTime());
			
>>>>>>> ajwad
		}
		
		
		//generate same entering time per who buy ticket
		this.t = ticketSystem.buy(rand.nextInt(4) + 1, timeEnter);
		
		
		if(this.t != null) {
	
			ExecutorService pool = Executors.newFixedThreadPool(t.length);
                        
            //Set same entrance for ticket groups
            int entrance = rand.nextInt(2);
            int staying = rand.nextInt(9000)+ 3000;
                        
			for (int i = 0; i < t.length; i++) {
				pool.execute(new Visitor(museum, t[i], entrance, staying));
			}
			
			pool.shutdown();
		}
		
	}

}
