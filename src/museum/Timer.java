
package museum;

import java.util.concurrent.atomic.AtomicInteger;

public class Timer implements Runnable{
//    private long timer;
    AtomicInteger timer;
    private int hour;
    private int minutes;
    private int startTimeInSec;
    
    
    private int timerSkip = 60;
    private int threadSleep = 5;
    
    private int CounterOpen = 28800; //08:00  (8am)
    private int CounterClose = 61200; // 17:00 (5pm)
    		
    private int MuseumOpen = 36300;  // 10:00 (10pm)
    private int MuseumClose = 64800; // 6pm
    private int MuseumActuallyClose = 67800; // 6:50pm
    
    
    public Timer(int hour, int minutes){

        this.hour = hour*3600;
        this.minutes = minutes*60;
        this.startTimeInSec = this.hour + this.minutes;
    	timer = new AtomicInteger(startTimeInSec);
    }
    
    public void run(){
        
        //Stops by 6:30pm
        while(timer.get()<=this.MuseumActuallyClose){
        	if(timer.get() == this.CounterOpen) {
        		System.out.println("Time is "+toString()+" Counter Is Open");
        	}
        	if(timer.get() == this.MuseumClose){
        		System.out.println("Time is "+toString()+" Museum Is Now Closed");
        	}
            try{
                Thread.sleep(this.threadSleep);
                timer.addAndGet(this.timerSkip);
                System.out.println("Time is "+ toString());
                
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public long getTime(){
        return timer.get();
    }
    
    public boolean isCounterOpen() {
    	if(timer.get()>=this.CounterOpen && timer.get()<=this.CounterClose) {
//    		System.out.println("Time is "+toString()+", ticket counter is not open");
    		return true;
    	}else {
    		return false;
    	}
    }
       
    public boolean isMuseumOpen() {
    	if(timer.get()>=this.MuseumOpen && timer.get()<=this.MuseumClose) {
//    		System.out.println("Time is "+toString()+", Museum is not open");
    		return false;
    	}else {
    		return true;
    	}
    }
    
    public boolean isMuseumActuallyClose() {
    	if(timer.get()<=this.MuseumActuallyClose) {
//    		System.out.println("Time is "+toString()+", Museum is not open");
    		return false;
    	}else {
    		return true;
    	}
    }
    
 
    public String toString(){
        int hour =(int) timer.get()/60;
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
