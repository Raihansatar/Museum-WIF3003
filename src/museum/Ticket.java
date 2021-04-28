package museum;

public class Ticket {

	private double timestamp;
	private int ID;
	String TicketID;
	public Ticket(int ID) {
		// TODO Auto-generated constructor stub
		this.setTimestamp(System.currentTimeMillis()); // basically this is to set the time on ticket for visitor to enter the museum
		this.setID(ID); // set id ticket
	}
	
	public double getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(double timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getID() {
		
		return TicketID;
	}
	public void setID(int iD) {
		ID = iD;
		TicketID = String.format("T%05d", ID); // set ticket id in format TXXXX
	}

}
