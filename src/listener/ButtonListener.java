package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


import map.MapConfig;

public class ButtonListener implements ActionListener, MapConfig{

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
			} catch (IOException ex) {
				ex.printStackTrace();
			} 			
		}
	}
	
}
