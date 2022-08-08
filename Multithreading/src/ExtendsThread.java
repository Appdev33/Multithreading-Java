


public class ExtendsThread {
	
//	public static void main(String[] args)
	{
		Runner runner1 = new Runner();
		runner1.start();  //Reason use start() ==> want to run Simultaneously
		
		Runner runner2 = new Runner();
		runner2.start();
	}
	
}

class Runner extends Thread{
	
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
}