import java.util.concurrent.Semaphore;

//###1. Introduce Semaphores Class(object)
//
//Semaphore :
//
//Mainly used to limit the number of simultaneous threads that can access a resources, but you can also use them to implement deadlock recovery systems since a semaphore with one permit is basically a lock that you can unlock from other threads.
//App.java
public class SemaphoresBasic {

	public static void main(String[] args) throws InterruptedException {
		
		Semaphore semaphore = new Semaphore(1);
		
		semaphore.release(); // +1 permits
		semaphore.acquire(); // -1 permits
		
		System.out.println(semaphore.availablePermits()); //1

	}

}
