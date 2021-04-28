package museum;

public class Ticket {

	private double timestamp;
	private int ID;
	String TicketID;
	public Ticket(int ID) {
		// TODO Auto-generated constructor stub
		this.setTimestamp(System.currentTimeMillis());
		this.setID(ID);
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
		TicketID = String.format("T%05d", ID);
	}

}
