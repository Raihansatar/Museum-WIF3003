package museum;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		
		//less then 9am
		if ((int)museum.getTimer().getTime() < museum.getTimer().getMuseumOpeningTime()) {
			
			//entry time = museum opening time + 0-10 minutes
			timeEnter = (int) ( museum.getTimer().getMuseumOpeningTime() + rand.nextInt(600) );
		} else {
			
			//entry time = current time + 0-10 minutes
                        timeEnter = (int) (museum.getTimer().getTime() + rand.nextInt(600));
		}
		
		
		//generate same entering time per who buy ticket
		this.t = ticketSystem.buy(rand.nextInt(4) + 1, timeEnter);
		
		
		if(this.t != null) {
	
			ExecutorService pool = Executors.newFixedThreadPool(t.length);
                        
            //Set same entrance for ticket groups
            int entrance = rand.nextInt(2);
            //Set time staying between 50 minutes to 150 minutes
            int staying = rand.nextInt(9000)+ 3000;
                        
			for (int i = 0; i < t.length; i++) {
				pool.execute(new Visitor(museum, t[i], entrance, staying));
			}
			
			pool.shutdown();
		}
		
	}

}
