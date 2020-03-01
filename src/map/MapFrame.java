package map;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class MapFrame implements MapConfig{
		
	static JFrame frame;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				showGUI();
			}
		});
	}

	private static void showGUI() {
		
		frame = new JFrame("Map editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Map(new MapReader()).mainPanel);			
		frame.pack();

		frame.setVisible(true);
	}
}


