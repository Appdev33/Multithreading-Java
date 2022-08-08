package MultithreadedMergeSort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainMergeSortMultithreaded {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(8);
		
		List<Integer> numbers = Arrays.asList(3,5,1,54,10,3,5,12,45,77,98,2);
		
		 ExecutorService executorService = Executors.newCachedThreadPool();
	        Future<List<Integer>> sortedListFuture = executorService.submit(
	                new Sorter(numbers, executorService)
	        );

	        List<Integer> sortedList = sortedListFuture.get();
	        System.out.println(sortedList);

	}

}
