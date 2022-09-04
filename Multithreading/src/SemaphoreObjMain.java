import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemaphoreObjMain {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 200; i++) {
			// submit => Create a new thread auto
			executor.submit(new Runnable() {

				@Override
				public void run() {
					ConnectionSema.getConnection().connect(); //Invoke
				}

			});
		}//ENDof For loop
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS); //Wait for 1 day then ONLY terminate
	}

}
