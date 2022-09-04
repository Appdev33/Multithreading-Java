/*
 https://www.geeksforgeeks.org/reentrant-lock-java/
 The traditional way to achieve thread synchronization in Java is by the use of synchronized keyword. While it provides a certain basic synchronization, the synchronized keyword is quite rigid in its use. For example, a thread can take a lock only once. Synchronized blocks don’t offer any mechanism of a waiting queue and after the exit of one thread, any thread can take the lock. This could lead to starvation of resources for some other thread for a very long period of time. 
Reentrant Locks are provided in Java to provide synchronization with greater flexibility.
 */

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DeadLockSolve {
	
	private DeadLockSolveAccount acc1 = new DeadLockSolveAccount();
	private DeadLockSolveAccount acc2 = new DeadLockSolveAccount();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	//Solution --> To DeadLock 
	private void acquireLocks(Lock lock1, Lock lock2) throws InterruptedException{
		while(true){
			//Acquire Lock
			Boolean gotFirstLock = false;
			Boolean gotSecondLock = false;
			
			try{
				gotFirstLock = lock1.tryLock(); //Return true if have
				gotSecondLock = lock2.tryLock();
			}finally{
				if (gotFirstLock && gotSecondLock){
					return;
				}
				
				if (gotFirstLock){
					lock1.unlock();
				}
				
				if (gotSecondLock){
					lock2.unlock();
				}
			}
			
			//Lock not acquired
			Thread.sleep(1);
		}
	}
	
	public void firstThread() throws InterruptedException{	
		Random random = new Random();
		 
		for (int i = 0; i < 1000; i++){
			acquireLocks(lock1,lock2);
			try{
				DeadLockSolveAccount.transfer(acc1, acc2, random.nextInt(100)); //Transfer range(0-99)
			}finally{
				lock1.unlock();
				lock2.unlock();
			}
		}
	}//EndOf firstThread()
	
	public void secondThread() throws InterruptedException{
		Random random = new Random();
		 
		for (int i = 0; i < 1000; i++){
			/*
			 * Dead Lock (Did not lock in the same Order)
			 * 
			 * lock2.lock(); 
			 * lock1.lock();
			 */
			acquireLocks(lock2,lock1);
			try{
				DeadLockSolveAccount.transfer(acc2, acc1, random.nextInt(100)); //Transfer range(0-99)
			}finally{
				lock1.unlock();
				lock2.unlock();
			}
		}
	}//EndOf secondThread()
	
	public void finished(){
	
		System.out.println("Account 1 Balance: " + acc1.getBalance());
		System.out.println("Account 2 Balance: " + acc2.getBalance());
		System.out.println("Total Account Balance: " + (acc1.getBalance() + acc2.getBalance()) );
	}//EndOf Finished()
	
	

}
