
package museum;

import java.util.concurrent.atomic.AtomicInteger;

public class Timer implements Runnable{
    
	private GUI gui;
    AtomicInteger timer;
    private int hour;
    private int minutes;
    private int startTimeInSec;
    
    
    private int timerSkip = 60; //skip time in seconds
    private int threadSleep = 500; //how fast the time skip
    
    private int CounterOpen = 28800; //08:00  (8am)
    private int CounterClose = 61200; // 17:00 (5pm)
    		
    private int MuseumOpen = 32400;  // 9:00 (9pm)
    private int MuseumClose = 64800; // 18:00 (6pm)
    private int MuseumActuallyClose = 67800; // 18:50 (6:50pm)
    
    
    public Timer(GUI gui,int hour, int minutes){
    	this.gui = gui;
        this.hour = hour*3600;
        this.minutes = minutes*60;
        this.startTimeInSec = this.hour + this.minutes;
    	this.timer = new AtomicInteger(startTimeInSec);
    }
    
    public void run(){
        
        while(timer.get()<=this.MuseumActuallyClose){
        	
        	if(timer.get() == this.CounterOpen) {
        		System.out.println("["+toString()+"] COUNTER IS OPEN");
        		gui.updateCounterGUI("COUNTER IS OPEN", true);
        	}
        	if(timer.get() == this.CounterClose) {
        		System.out.println("["+toString()+"] COUNTER IS CLOSED");
        		gui.updateCounterGUI("COUNTER IS CLOSED", false);
        	}
        	if(timer.get() == this.MuseumOpen){
        		System.out.println("["+toString()+"] MUSEUM IS OPEN");
        		gui.updateMuseumGUI("MUSEUM IS OPEN", true);
        	}
        	if(timer.get() == this.MuseumClose){
        		System.out.println("["+toString()+"] MUSEUM IS CLOSED");
        		gui.updateMuseumGUI("MUSEUM IS CLOSED", false);
        	}
        	
            try{
                Thread.sleep(this.threadSleep);
                timer.addAndGet(this.timerSkip);
                
                gui.updateTimeGUI("TIME: "+toString());
//                
//                System.out.println("["+toString()+"]");
                
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public int getTime(){
        return timer.get();
    }
    
    public int getMuseumClosingTime() {
    	return this.MuseumClose;
    }
    
    public int getMuseumOpeningTime() {
    	return this.MuseumOpen;
    }
    
    public int getCounterClosingTime() {
    	return this.CounterClose;
    }
    
    public int getCounterOpeningTime() {
    	return this.CounterOpen;
    }
    
    public boolean isCounterOpen() {
    	if(timer.get()>=this.CounterOpen && timer.get()<=this.CounterClose) {
    		return true;
    	}else {
    		return false;
    	}
    }
       
    public boolean isMuseumOpen() {
    	if(timer.get()>=this.MuseumOpen && timer.get()<=this.MuseumClose) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public boolean isMuseumActuallyClose() {
    	if(timer.get()<=this.MuseumActuallyClose) {
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
