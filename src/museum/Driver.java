package museum;

import java.util.Random;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		Timer timer = new Timer();
    	Thread tt = new Thread(timer);
    	tt.setName("Timer thread");
    	tt.start();
        
		Museum m = new Museum(30, 100, timer);
		//	create museum object with parameter ( maxVisitor, total ticket available, timer thread)
		
		Thread [] th = new Thread[50]; //define number of person buying ticket
		
		// create thread of person that buying the ticket and start
		for (int i = 0; i < th.length; i++) {
			th[i] = new Thread(new Ticketing(m));
		}
		
		for (int i = 0; i < th.length; i++) {
			try {
				Thread.sleep(rand.nextInt(2400) + 600);
			} catch (Exception e) {
				// TODO: handle exception
			}
			th[i].start();
		}
	}

}
