/*
 * Low Level Synchronization (Example) 
 * Run Concurently(Simultaneously)
 */
public class SyncronisationLowLevelMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final SyncronisationLowLevel processor = new SyncronisationLowLevel();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		//Start
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}
