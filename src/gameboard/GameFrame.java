package gameboard;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import things.Player;

public class GameFrame {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new GameFrame().showGUI();
			}			
		});
	}
	
	private void showGUI() {
		//init game frame
		JFrame frame = new JFrame("Game board");
		frame.add(new GamePanel());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Thread panelThread = new Thread(new GamePanel());
		Thread playerThread = new Thread(new Player());
		panelThread.start();
		playerThread.start();
	}
}
