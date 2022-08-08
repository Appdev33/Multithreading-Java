import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCallableMain {
		public static void main(String[] args) throws InterruptedException, ExecutionException {
			ExecutorService executorService = Executors.newFixedThreadPool(8);
			
			Future<Integer> value=null;
			for(int i=0;i<=100;i++) {

				value = executorService.submit(new SquareCallableCall(i));
//				Future<Integer> value = executorService.submit(new SquareCallableCall(i));
				System.out.println(value.get());
			}
//			try {
//				System.out.println(value.get());
//			} catch (InterruptedException | ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
}
