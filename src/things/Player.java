package things;

public class Player implements Runnable{

	
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(20);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
