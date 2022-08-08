package PrintNumsMultithread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrintNumsMain {

	public static void main(String[] args) {
		
		//Task Management in production
		ExecutorService executorService = Executors.newFixedThreadPool(50);
		
//		Thread t1 = new Thread(new PrintNums());
//		Thread t2 = new Thread(new PrintNums());
//		t1.start();
//		t2.start();
		
//		System.out.print("hello"+Thread.currentThread().getName());
		for(int i=1;i<=100;i++) {
			
			// With Executors no need to even start thread
			//blocking threads in executors
			
			executorService.execute(new PrintNums(i) );
//			executorService.submit(new PrintNums(i) );
			
			//Telling thread i to print number i
//			Thread t = new Thread(new PrintNums(i));
//			t.start(); //for all 100 threads
			
			executorService.shutdown();
			//stop executor service to let main() thread know and continue
			try {
//			
				executorService.awaitTermination(10L, TimeUnit.SECONDS);
			}
			catch (Exception e) {}
				
		}
		
	}
}
