package museum;

import java.util.Random;

public class Visitor implements Runnable{

	protected Museum museum;
	protected Random rand = new Random();
	protected Ticket ticket;
	protected int staying;
	
	public Visitor(Museum museum, Ticket ticket) {
		// TODO Auto-generated constructor stub
		this.museum = museum;
		this.ticket = ticket;
		this.staying = rand.nextInt(10000) + 1000;
		
	}
	
	@Override
	public void run() {
		
		this.staying = rand.nextInt(9000)+ 3000; //random staying time
		
		// before enter, visitor need to check the enter time on the ticket
		// here code to check enter time should be here
		
        //check if before 9:00am
//        while(museum.getTimer().getTime()<32400){
//            System.out.println("Time is "+museum.getTimer().toString()+", museum not opened yet");
//        }
        
//      
		
		boolean enter = false;
		while(museum.getTimer().getTime()<67800){
			if(museum.getTimer().getTime()<32400){
//	            System.out.println("Time is "+ museum.getTimer().toString());
	        }else {
	        	if(( this.ticket.getTimestamp() <= museum.getTimer().getTime() ) && enter == false ) {
	        		
	        		int random = rand.nextInt(2); // randomly assigned gate to visitor to enter
	        		if(random == 0) {
	        			this.museum.enterNorth(this.ticket, staying/60);
	        		}else {
	        			this.museum.enterSouth(this.ticket, staying/60);
	        		}
	        		enter = true;
	        	}
	        	
	        }
			
			
			if( (enter == true) && ((this.ticket.getTimestamp() + this.staying) <= museum.getTimer().getTime() ) || museum.getTimer().getTime() > 64800) {
				int random = rand.nextInt(2); // randomly assigned gate to visitor to exit
				if(random == 0) {
					this.museum.exitEast(this.ticket);
				}else {
					this.museum.exitWest(this.ticket);
				}
				break;
			}
		}
        
	}

}
