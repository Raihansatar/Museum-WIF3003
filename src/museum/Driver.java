package museum;

import java.util.Random;
import java.util.Scanner;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
            
//marijana check 
// TODO Auto-generated method stub
            Random rand = new Random();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter start time in hours: ");
            int hours = scan.nextInt();
            System.out.println("Enter start time in minutes: ");
            int minutes = scan.nextInt();
            
            System.out.println("Enter maximum number of visitors: ");
            int maxVisitors = scan.nextInt();
            System.out.println("Enter maximum number of tickets: ");
            int totalTickets = scan.nextInt();
            
            System.out.println("Enter number of people buying the tickets: ");
            int ticketThread = scan.nextInt();
            
            Timer timer = new Timer(hours, minutes);
            Thread tt = new Thread(timer);
            tt.setName("Timer thread");
            tt.start();
            
            Museum m = new Museum(maxVisitors, totalTickets, timer);
            //	create museum object with parameter ( maxVisitor, total ticket available, timer thread)

            Thread [] th = new Thread[ticketThread]; //define number of person buying ticket

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
