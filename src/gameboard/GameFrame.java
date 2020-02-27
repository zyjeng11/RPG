package gameboard;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import things.Player;

public class GameFrame {
	
	Player player;
	
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
		player = new Player();
		JPanel gamePanel = new GamePanel(player);
		frame.add(gamePanel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Thread panelThread = new Thread((Runnable) gamePanel);
		Thread playerThread = new Thread(player);
		panelThread.start();
		playerThread.start();
	}
}
