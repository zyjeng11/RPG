package things;

import gameboard.GameConfig;

public class Player implements Runnable, GameConfig{

	static int x = boardWidth/2;
	static int y = boardHeight/2;
	
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
