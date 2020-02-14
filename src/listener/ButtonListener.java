package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JPanel;

import map.MapConfig;
import map.MapReader;

public class ButtonListener implements ActionListener, MapConfig{

	private JPanel panel;
	
	public ButtonListener(JPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("save")) {
			String path = MapConfig.class.getResource(relativePath).getPath();
			try (FileOutputStream fout = new FileOutputStream(path);
				DataOutputStream dout = new DataOutputStream(fout);)
			{							
				for(int i=0; i<map1[0].length; i++) {
					for(int j=0; j<map1.length; j++) {
						dout.writeInt(map1[i][j]);
						dout.writeInt(map2[i][j]);
					}
				}
				System.out.println("map saved");
			} catch (IOException ex) {
				ex.printStackTrace();
			} 			
		}else if(e.getActionCommand().equals("load")){
			new MapReader().readMap();
			panel.repaint();
		}
	}
	
}
