package gameboard;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
		JFrame frame = new JFrame("Game board");
		frame.add(new GamePanel());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
