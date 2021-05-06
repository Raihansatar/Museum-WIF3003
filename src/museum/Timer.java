
package museum;

import java.util.concurrent.atomic.AtomicInteger;

public class Timer implements Runnable{
//    private long timer;
    AtomicInteger timer;
    private int hour;
    private int minutes;
    private int startTimeInSec;
    
    private int timerSpeed = 1;
    private int threadSleep = 5;
    
    public Timer(int hour, int minutes){

        this.hour = hour*3600;
        this.minutes = minutes*60;
        this.startTimeInSec = this.hour + this.minutes;
    	timer = new AtomicInteger(startTimeInSec);
    }
    
    public void run(){
        
        //Stops by 6:30pm
        while(timer.get()<=67800){
            try{
                Thread.sleep(this.threadSleep);
                timer.addAndGet(this.timerSpeed);
                if(timer.get() == 67800){
                    System.out.println("Time is 6:00pm, museum is now closed");
                }
                
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public long getTime(){
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
