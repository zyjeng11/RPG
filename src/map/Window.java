package map;

import java.awt.*;
import javax.swing.*;

public class Window implements MapConfig{
		
	static JFrame frame;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Window().showGUI();
			}
		});
	}

	private void showGUI() {
		
		frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.add(new ScrolledPanel());			
		frame.pack();

		frame.setVisible(true);
	}
}


