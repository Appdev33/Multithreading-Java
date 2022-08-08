
public class ThreadsLamda2 {
	
	public static void main(String[] args)
	{
		
		Thread thread2 = new Thread(()->{
			while(true) {
				System.out.println("Hello "+Thread.currentThread().getName());
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
