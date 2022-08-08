import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
	 * Thread Pools => Managing Lock Threads @ same time 
	 * Thread  => Is like how many numbers of worker in your factory
	 * Run Concurently(Simultaneously)
	 */

public class ThreadPools {
	
	public static void main(String[] args) {
		//Thread Pool
		ExecutorService executor = Executors.newFixedThreadPool(2);
	}
	
}

class Processor implements Runnable{

	private int id;
	
	public Processor(int id) {
		this.id =id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting: " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed: " + id);
	}
}
