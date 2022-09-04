
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableFutureMain {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				System.out.println("Starting...");
				
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Finish...");
			}		
		});
		
		executor.shutdown();
	}
}
