package museum;

import java.util.Random;

public class Visitor implements Runnable{

	protected Museum museum;
	protected Random rand = new Random();
	protected Ticket ticket;
	protected int staying;
        protected int entrance;
	
	public Visitor(Museum museum, Ticket ticket, int entrance, int staying) {
		// TODO Auto-generated constructor stub
		this.museum = museum;
		this.ticket = ticket;
		this.staying = staying;
        this.entrance = entrance;
		
	}
	
	@Override
	public void run() {
		
		boolean enter = false;
		int currentEnterTime = 0;
		//while museum is not actually closed
		while(!museum.getTimer().isMuseumActuallyClose()){
			
			// if museum is open
			if(museum.getTimer().isMuseumOpen()){

				// if ticket timemestamp is actual timer is less && visitor has not enter
	            if(( this.ticket.getTimestamp() <= museum.getTimer().getTime() ) && enter == false ) {
	
	                if(entrance == 0){
	                    this.museum.enterNorth(this.ticket, staying/60);
	                }
	                else{
	                     this.museum.enterSouth(this.ticket, staying/60);
	                }
	                enter = true;
	                currentEnterTime = museum.getTimer().getTime();
	            }

            }
			
			
			// if already enter
			// and timestamp + staying time < current time      (finished visiting)
			// or museum is closed
			
			int exitTime = currentEnterTime + this.staying;
			if( ((enter == true) && ((exitTime) <= museum.getTimer().getTime())) 
					|| (museum.getTimer().getTime() >= museum.getTimer().getMuseumClosingTime())) {
				
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
