package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import map.MapConfig;
import map.MapReader;
import map_part.ImageButton;

public class ButtonListener implements ActionListener, MapConfig {

	private JPanel panel;
	private JLabel label;
	private ImageButton button;

	public ButtonListener(JPanel panel, JLabel label) {
		this.panel = panel;
		this.label = label;
	}
	
	public ButtonListener(JPanel panel, JLabel label, ImageButton button) {
		this.panel = panel;
		this.label = label;
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// method that save the map into the file
		if (e.getActionCommand().equals("save")) {
			String path = MapConfig.class.getResource(relativePath).getPath();
			try (FileOutputStream fout = new FileOutputStream(path);
					DataOutputStream dout = new DataOutputStream(fout);) {
				for (int i = 0; i < map1[0].length; i++) {
					for (int j = 0; j < map1.length; j++) {
						dout.writeInt(map1[i][j]);
						dout.writeInt(map2[i][j]);
					}
				}
				System.out.println("map saved");
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		// method that load the map from the file
		} else if (e.getActionCommand().equals("load")) {
			new MapReader().readMap();
			panel.repaint();
			System.out.println(iconsMap1[0][0]);
		} 
		// press an image button
		else if(e.getActionCommand().equals("image")) {
			Icon icon = button.getIcon();
			label.setIcon(icon);
			label.repaint();
		}		
	}

}
