import java.util.concurrent.Callable;

public class SquareCallableCall implements Callable<Integer>{
	
	private int numToCalculate;
	public SquareCallableCall(int numToCalculate) {
		this.numToCalculate=numToCalculate; 
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return this.numToCalculate*this.numToCalculate;
	}

}
