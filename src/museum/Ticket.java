package museum;

public class Ticket {

	private double timestamp;
	private int ID;
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
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

}
