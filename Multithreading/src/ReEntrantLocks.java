import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class ReEntrantLocks {

	private int count = 0;
	private Lock lock = new ReentrantLock(); //Alternative to Synchronized
	private Condition condition = lock.newCondition();
	
	private void increment(){
		for (int i = 0; i < 1000; i++){
			count++;
			System.out.println("Print Hello");
		}
	}
	public void firstThread() throws InterruptedException{
		lock.lock();
		
		System.out.println("Waiting...");
		condition.await();  //Wait until signal() is invoked (No1)
		
		System.out.println("Woken Up!");
		try {
			increment(); //Use try-catch => prevent Exception 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}
	
	public void secondThread() throws InterruptedException{
		Thread.sleep(10);
		lock.lock();
		
		System.out.println("Press The return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");
		
		condition.signal(); //No1
		try {
			increment(); //Use try-catch => prevent Exception 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void finished(){
		System.out.println("Count: " + count);
	}
}
