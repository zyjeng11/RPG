package gameboard;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import map.*;

public class GamePanel extends JPanel implements MapConfig {

	public GamePanel() {
		
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(MapWidth, MapHeight));
		JScrollPane js = new JScrollPane(centerPanel);			
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1200, 700));		
		this.add(js, BorderLayout.CENTER);

		new MapReader().readMap();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < iconsMap1[0].length; i++) {
			for (int j = 0; j < iconsMap1.length; j++) {
				if (iconsMap1[i][j] != null)
					iconsMap1[i][j].paintIcon(null, g, i*eleWidth, j*eleHeight);
					//g.drawImage(iconsMap1[i][j].getImage(), i * eleWidth, j * eleHeight, eleWidth, eleHeight, null);
			}
		}
		for (int i = 0; i < iconsMap2[0].length; i++) {
			for (int j = 0; j < iconsMap2.length; j++) {
				if (iconsMap2[i][j] != null)
					iconsMap2[i][j].paintIcon(null, g, i*eleWidth, j*eleHeight);
					//g.drawImage(iconsMap2[i][j].getImage(), i * eleWidth, j * eleHeight, eleWidth, eleHeight, null);
			}
		}
	}
		
}
