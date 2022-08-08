package printEvenOdd;


public class Printer implements Runnable{
	private final int step;
    private final State state;
    private int currentValue;
    private final PrinterType currentPrinterType;
    private final PrinterType nextPrinterType;
    private final int maxValue;
	

    public Printer(final Integer startValue,  final int step,  final State state,
            final PrinterType currentPrinterType, final PrinterType nextPrinterType,
           Integer maxValue) {
	 this.currentValue = startValue;
	 this.step = step;
	 this.state = state;
	 this.currentPrinterType = currentPrinterType;
	 this.nextPrinterType = nextPrinterType;
	 this.maxValue = maxValue;
	}

		
	@Override
	public void run() {
		while(currentValue<=maxValue) {
			
			synchronized (state){
				while(this.currentPrinterType!= state.getNextToPrint()) {
					try {
						state.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(currentPrinterType.toString()+":"+currentValue);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentValue+=step;
				state.setNextToPrint(this.nextPrinterType);
				state.notifyAll();
			}
			
		}
		
	}	
}
