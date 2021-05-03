package museum;

public class Ticket {

	private int timeEnter;
	private int ID;
	String TicketID;
	public Ticket(int ID, int timeEnter) {
		// TODO Auto-generated constructor stub
		this.setID(ID); // set id ticket
		this.timeEnter = timeEnter;
		System.out.print(" time - " + getTicketTime() + " ");
	}
	
	public int getTimestamp() {
		return timeEnter;
	}
	
	public void setTimestamp(int timestamp) {
		this.timeEnter = timestamp;
	}
	
	public String getID() {
		
		return TicketID;
	}
	public void setID(int iD) {
		ID = iD;
		TicketID = String.format("T%05d", ID); // set ticket id in format TXXXX
	}
	
	public String getTicketTime(){
        int hour =(int) timeEnter/60;
        int min = (int) hour % 60;
        hour = hour/60;
        if(min < 10){
            return hour + ":0"+min;
        }
        else{
             return hour + ":" + min;
        }
       
    }

}
