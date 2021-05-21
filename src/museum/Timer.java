
package museum;

import java.util.concurrent.atomic.AtomicInteger;

public class Timer implements Runnable{
<<<<<<< HEAD
=======

>>>>>>> ajwad
    AtomicInteger timer;
    private int hour;
    private int minutes;
    private int startTimeInSec;
    
    
    private int timerSkip = 60; //skip time in seconds
    private int threadSleep = 5; //how fast the time skip
    
    private int CounterOpen = 28800; //08:00  (8am)
    private int CounterClose = 61200; // 17:00 (5pm)
    		
    private int MuseumOpen = 32400;  // 9:00 (9pm)
    private int MuseumClose = 64800; // 18:00 (6pm)
    private int MuseumActuallyClose = 67800; // 18:50 (6:50pm)
    
    
    public Timer(int hour, int minutes){
        this.hour = hour*3600;
        this.minutes = minutes*60;
        this.startTimeInSec = this.hour + this.minutes;
    	this.timer = new AtomicInteger(startTimeInSec);
    }
    
    public void run(){
        
        //Stops by 6:30pm
<<<<<<< HEAD
        while(timer.get()<=66600){
            try{
                Thread.sleep(50);
                timer.addAndGet(30);
                if(timer.get() == 64800){
                    System.out.println("Time is 6:00pm, museum is now closed");
                }
=======
>>>>>>> ajwad
                
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public int getTime(){
        return timer.get();
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
