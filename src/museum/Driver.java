package museum;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
            // TODO Auto-generated method stub
            Random rand = new Random();
            Scanner scan = new Scanner(System.in);
            GUI gui = new GUI();
            
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
            
            Timer timer = new Timer(gui, hours, minutes);
            Thread tt = new Thread(timer);
            tt.setName("Timer thread");
            tt.start();
            
            Museum museum = new Museum(maxVisitors, totalTickets, timer);
            //	create museum object with parameter ( maxVisitor, total ticket available, timer thread)

            ExecutorService pool = Executors.newFixedThreadPool(ticketThread);
            
            // create thread of person that buying the ticket and start
            for (int i = 0; i < ticketThread; i++) {
                pool.execute(new Ticketing(museum));
            }
		
            pool.shutdown();            

	}

}
