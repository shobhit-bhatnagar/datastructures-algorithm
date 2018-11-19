/**
 * 
 */
package concurrentapi;

import java.util.concurrent.CyclicBarrier;

/**
 * @author shobhit
 *
 */
public class CustomCyclicBarrier extends CyclicBarrier{

	private int initialParties;
	private int partiesAwait;
	private Runnable cyclicBarrrierEvent;
	
	

	/**
	 * 
	 */
	public CustomCyclicBarrier(int count, Runnable cyclicBarrrierEvent) {
		super(count,cyclicBarrrierEvent);
		 initialParties=count;
         partiesAwait=count;   
         this.cyclicBarrrierEvent=cyclicBarrrierEvent;
	}
	
	 /**
     *  If the current thread is not the last to arrive(i.e. call await() method) then
     it waits until one of the following things happens -
                  - The last thread to call arrive(i,.e. call await() method), or
                  - Some other thread interrupts the current thread, or
                  - Some other thread interrupts one of the other waiting threads, or
                  - Some other thread times out while waiting for barrier, or
                  - Some other thread invokes reset() method on this cyclicBarrier.
	 * @return 
     */
    public synchronized int await() throws InterruptedException {
           //decrements awaiting parties by 1.
           partiesAwait--;
           
           //If the current thread is not the last to arrive, thread will wait.
           if(partiesAwait>0){
                  this.wait();
           }
           /*If the current thread is last to arrive, notify all waiting threads, and
            launch event*/
           else{
                  /* All parties have arrive, make partiesAwait equal to initialParties,
                    so that CyclicBarrier could become cyclic. */
                  partiesAwait=initialParties;
                  
                  notifyAll(); //notify all waiting threads
                  
                  cyclicBarrrierEvent.run(); //launch event
           }
           return 1;
    }
    
    public static void main(String [] args)
	{
		Runnable barrier1Action = new Runnable() {
		    public void run() {
		        System.out.println("BarrierAction 1 custom executed ");
		    }
		};
		Runnable barrier2Action = new Runnable() {
		    public void run() {
		        System.out.println("BarrierAction 2 custom executed ");
		    }
		};

		CustomCyclicBarrier barrier1 = new CustomCyclicBarrier(2, barrier1Action);
		CustomCyclicBarrier barrier2 = new CustomCyclicBarrier(2, barrier2Action);

		CyclicBarrierRunnable barrierRunnable1 =
		        new CyclicBarrierRunnable(barrier1, barrier2);

		CyclicBarrierRunnable barrierRunnable2 =
		        new CyclicBarrierRunnable(barrier1, barrier2);

		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();

	}

}
