import java.util.concurrent.Semaphore;

public class ConnectionSema {
	
	private static ConnectionSema instance = new ConnectionSema();
	private int connections=0;
	
	//Semaphore
	
	private Semaphore semaphore = new Semaphore(10);
	
	private ConnectionSema() {}
	
	public static ConnectionSema getConnection() {
		return instance;
	}
	
	public void connect() {
		try {
			semaphore.acquire(); // -1
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		try{
			doConnect();
		}finally{
			semaphore.release(); // +1
		}
	}
	
	public void doConnect(){
			
			synchronized(this){
				connections++;
				System.out.println("Current Connections: " + connections);
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized(this){
				connections--;
			}
	}
}
