
public class DeadLockSolveMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		final DeadLockSolve runner = new DeadLockSolve();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					runner.secondThread();
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
		
		runner.finished();

	}

}
