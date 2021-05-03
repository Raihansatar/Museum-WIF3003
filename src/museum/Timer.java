
package museum;


public class Timer implements Runnable{
    private long timer;
    
    public Timer(){
        //timer starts at 7:00am
        this.timer=25200;
    }
    
    public void run(){
        
        //Stops by 6:30pm
        while(timer<=67800){
            try{
                Thread.sleep(50);
                timer=timer+30;
                
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public long getTime(){
        return timer;
    }
    
    public String toString(){
        int hour =(int) timer/60;
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
