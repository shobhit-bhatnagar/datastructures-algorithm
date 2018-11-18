package multithreading;

public class MainApp {

	public static void main(String [] args) throws InterruptedException
	{
		
		TestMethod met = new TestMethod();
		
		for(int i=1;i<=10;i++)
		{
			Thread t = new Thread(new Threadtest(met), "Thread-"+i);
			t.start();
		}
		Thread.currentThread().join();
		System.out.println(met.i);
	}
}
