package map;

import java.awt.*;
import javax.swing.*;

public class MapFrame implements MapConfig{
		
	static JFrame frame;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MapFrame().showGUI();
			}
		});
	}

	private void showGUI() {
		
		frame = new JFrame("Map editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Map().mapPanel);			
		frame.pack();

		frame.setVisible(true);
	}
}


