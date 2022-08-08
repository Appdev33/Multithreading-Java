
public class SyncronisedStop {
	private volatile int count = 0;
//	private static volatile int countVolatile=0;

		
		public static void main(String[] args) {
			SyncronisedStop app = new SyncronisedStop();
			app.doWork();
		}//ENDof Main
		
		//
		//Use SYNCHRONIZED ///////////////
		//This allows only one thread to execute once else both thread can access values and overwrite and result not 20
		// Either use synchronised here or make variable volatile else count wil be not 2000 same method accessed same time
//		synchronized
		public  void increment(){
			count++;
		}
		public void doWork(){
			Thread thread1 = new Thread(new Runnable(){

				@Override
				public void run() {
					for (int i = 0; i < 10000; i++){
						increment();
					}
				}
				
			});
			
			Thread thread2 = new Thread(new Runnable(){

				@Override
				public void run() {
					for (int i = 0; i < 10000; i++){
						increment();
					}
				}
				
			});
			
			thread1.start();
			thread2.start();
			
			//Wait for the thread to Finish 
			try {
				thread1.join();
				thread2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Count is " + count);
		}//ENDof doWork()
	
}
