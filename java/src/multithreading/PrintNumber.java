package multithreading;

public class PrintNumber {

	static boolean one = true;
	static boolean two = false;
	static boolean three = false;
	static Object monitor = new Object();
	static int value = 1;
	public static void main(String[] args) {

		for(int i =1;i<=3;i++)
		{
			Thread t = new Thread(new ThreadPrinter(i));
			t.start();
		}
		
	}

	static class ThreadPrinter implements Runnable {

		private int id;

		public ThreadPrinter(int id) {
			this.id = id;
		}

		@Override
		public void run() {

			try {
				print();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void print() throws InterruptedException {

			while (true) {
				if(value == 50)
				{
					break;
				}
				synchronized (monitor) {
					if (this.id == 1) {
						if (!one) {
							monitor.wait();
						} else {
							System.out.println(value++);
							one = false;
							two = true;
							three = false;
							monitor.notifyAll();
						}
					} else if (this.id == 2) {
						if (!two) {
							monitor.wait();
						} else {
							System.out.println(value++);
							one = false;
							two = false;
							three = true;
							monitor.notifyAll();
						}
					} else if (this.id == 3) {
						if (!three) {
							monitor.wait();
						} else {
							System.out.println(value++);
							two = false;
							three = false;
							one = true;
							monitor.notifyAll();
						}
					}

				}
			}

		}

	}

}
