import javax.swing.SwingUtilities;

public class SwingMultiThreadingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new SwingMultiThreading("SwingWorker Demo");
            }
        });
	}

}
