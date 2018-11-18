package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Threadtest implements Runnable
{
	
	TestMethod method = null;
	
	public Threadtest(TestMethod meth)
	{
		this.method = meth;
	}
	@Override
	public void run() {
		
		this.method.increment();
	}

	
	
	public static void main(String[] arg)
	{
		
		Executor e = Executors.newFixedThreadPool(3);
		
		  TestMethod tm  = new TestMethod();
		e.execute(new Thread(new Threadtest(tm),"Thread 1"));
		e.execute(new Thread(new Threadtest(tm),"Thread 2"));
		e.execute(new Thread(new Threadtest(tm),"Thread 3"));
		
		
	}
}
