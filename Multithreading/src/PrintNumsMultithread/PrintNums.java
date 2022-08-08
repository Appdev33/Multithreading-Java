package PrintNumsMultithread;

public class PrintNums implements Runnable {
	
	private int numberToPrint;
	
	public PrintNums(int numToPrint) {
		this.numberToPrint = numToPrint;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

			System.out.println(this.numberToPrint+"  "+ Thread.currentThread().getName()); 
	}
}
