package multithreading;

import java.util.concurrent.Executors;

class ReverseThread extends Thread
{
  private int counter;
 public ReverseThread(int counter)
 {
   super("Thread" + counter);
   this.counter = counter;
 }
  
 public void run()
 {
   counter++ ;
   if(counter <= 51)
   {
   ReverseThread thr = new ReverseThread(counter);
   thr.start();
   try { 
	   thr.join();
       System.out.println("Hello from "+ getName()); 
  }
  catch (Exception e)
  {
   //do smth
  }
   }
 } 

 public static void main (String args[])
 {
   ReverseThread th1 = new ReverseThread(1);
   th1.start();
 }
 
}

