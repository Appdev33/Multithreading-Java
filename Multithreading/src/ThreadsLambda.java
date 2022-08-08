
public class ThreadsLambda {
	
	public static void main(String[] args)
	{
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				for(int i=0; i<10;i++) {
					System.out.println("Hello "+i+Thread.currentThread().getName());
					try {
						Thread.sleep(100);
						
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();  //Reason use start() ==> want to run Simultaneously
		
		Thread thread2 = new Thread(()->{
			for(int i=0; i<10;i++) {
				System.out.println("Hello "+i+Thread.currentThread().getName());
				try {
					Thread.sleep(100);
					
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread2.start();  //shorter implementation using lambda
	}
	
}
