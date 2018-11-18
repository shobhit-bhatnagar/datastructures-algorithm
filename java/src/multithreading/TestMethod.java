package multithreading;

public class TestMethod {
	
	FairLock lock = new FairLock();
	int i=0;
	public void increment() 
	{
		try 
		{
			
			lock.lock();
			Thread.sleep(4000);
			System.out.println("Updated by thread " +Thread.currentThread().getName());
			i++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}

}
