
package museum;

import java.util.concurrent.atomic.AtomicInteger;

public class Timer implements Runnable{
    AtomicInteger timer;
    private int hour;
    private int minutes;
    private int startTimeInSec;
    
    public Timer(int hour, int minutes){

        this.hour = hour*3600;
        this.minutes = minutes*60;
        this.startTimeInSec = this.hour + this.minutes;
    	this.timer = new AtomicInteger(startTimeInSec);
    }
    
    public void run(){
        
        //Stops by 6:30pm
        while(timer.get()<=66600){
            try{
                Thread.sleep(50);
                timer.addAndGet(30);
                if(timer.get() == 64800){
                    System.out.println("Time is 6:00pm, museum is now closed");
                }
                
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
