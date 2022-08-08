import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLocksWorker2 {
	
	private Random random = new Random();
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	/*
	 * Multiple Locks: Use of Synchronized Code Blocks
	 * Run Concurently(Simultaneously)
	 */
	
	//Synchronized => Enquire the monitor log => Slow process 
	//Having Multiple Threads will slow down 
	// So.... use this method to ... make the process a little faster
	public void stageOne() {
		//Only 1 Thread @ a time -> Faster process
		synchronized(lock1){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}
	
	public synchronized void stageTwo() {
		//Only 1 Thread @ a time -> Faster process
		synchronized(lock2){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
	
	
	public void process() {
		for(int i=0;i<1000;i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main() {
		System.out.println("Starting ....");
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				process();
			}
		});
				
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		System.out.println("Time take: " + (end-start) + " ms");
		System.out.println("List 1 Length: " + list1.size() +
				"; List 2 Length: " + list2.size());
	}
}
