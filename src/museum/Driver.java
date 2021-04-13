package museum;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Museum m = new Museum(10, 10);
		TicketSystem ts = new TicketSystem(m);
		Ticketing t = new Ticketing(m, ts);
		
		Thread [] th = new Thread[20];
		for (int i = 0; i < th.length; i++) {
			th[i] = new Thread(new Ticketing(m, ts));
		}
		
		for (int i = 0; i < th.length; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			th[i].start();
		}
	}

}
