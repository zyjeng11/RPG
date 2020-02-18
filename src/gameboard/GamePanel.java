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
		for (int i = 0; i < smallIconsMap1[0].length; i++) {
			for (int j = 0; j < smallIconsMap1.length; j++) {
				if (smallIconsMap1[i][j] != null)
					smallIconsMap1[i][j].paintIcon(null, g, i*eleWidth, j*eleHeight);
					//g.drawImage(smallIconsMap1[i][j].getImage(), i * eleWidth, j * eleHeight, eleWidth, eleHeight, null);
			}
		}
		for (int i = 0; i < smallIconsMap2[0].length; i++) {
			for (int j = 0; j < smallIconsMap2.length; j++) {
				if (smallIconsMap2[i][j] != null)
					smallIconsMap2[i][j].paintIcon(null, g, i*eleWidth, j*eleHeight);
					//g.drawImage(smallIconsMap2[i][j].getImage(), i * eleWidth, j * eleHeight, eleWidth, eleHeight, null);
			}
		}
	}
		
}
