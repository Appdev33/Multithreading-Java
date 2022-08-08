import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLocksWorker {
	
	Random random = new Random();
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
//	public void stageOne() 
	//Synchronized => Enquire the monitor log => Slow process
	public synchronized void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(random.nextInt(100));
	}
	
//	public void stageTwo() 
	//Synchronized => Enquire the monitor log => Slow process
	public synchronized void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list2.add(random.nextInt(100));
	}
	
	public void process() {
		for(int i=0;i<1000;i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main(String[] args) {
		
//		// TODO Auto-generated method stub
//		System.out.println("Starting ....");
//		long start = System.currentTimeMillis();
//		process();
//		long end = System.currentTimeMillis();
//		
//		System.out.println("Time take: " + (end-start) + " ms");
//		System.out.println("List 1 Length: " + list1.size() +
//				"; List 2 Length: " + list2.size());
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
