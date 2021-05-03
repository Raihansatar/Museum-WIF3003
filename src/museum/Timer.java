
package museum;

import java.util.concurrent.atomic.AtomicInteger;

public class Timer implements Runnable{
//    private long timer;
    AtomicInteger timer;
    
    public Timer(){
        //timer starts at 7:00am
//        this.timer=25200;
    	timer = new AtomicInteger(25200);
    }
    
    public void run(){
        
        //Stops by 6:30pm
        while(timer.get()<=67800){
            try{
                Thread.sleep(50);
//                timer=timer+30;
                timer.addAndGet(30);
                
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public long getTime(){
//        return timer;
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
