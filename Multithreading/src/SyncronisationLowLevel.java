import java.util.LinkedList;
import java.util.Random;

public class SyncronisationLowLevel {
	
	private LinkedList <Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object(); //LockOn 
	
	public void produce() throws InterruptedException {
		
		int value =0;
		
		while(true) { //Infinite Loop
			
			synchronized(lock)
			{
				while(list.size()==LIMIT) {
					//wait until the current thread invoke notify()
					lock.wait();  //No1
				}
				list.add(value++);
				System.out.println("Added");
				lock.notify(); // Will wake up the consume() @ No2
			}
		}
	} //Endof Produce()
	
	public void consume() throws InterruptedException {
		
		Random random = new Random();
		
		while(true) {
			synchronized(lock)
			{
				while(list.size()==0) {
					lock.wait(); //No2
				}
				System.out.print("List Size: "+list.size());
				int value = list.removeFirst();
				System.out.print("; value: " + value);
				System.out.println("Removed");
				lock.notify(); // Will wake up thread @ No1
			}//EndOf Synchronized()
			
			Thread.sleep(random.nextInt(1000)); //0-999
		} //Endof While
		
	} //Endof Consume()
}
