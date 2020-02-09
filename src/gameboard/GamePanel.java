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
		
		for (int i = 0; i < 2; i++) {
			icons[i] = MapPanel.creatImageIcon("/img/" + iconsName[i] + ".jpg");
		}		
		read();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < iconsMap1[0].length; i++) {
			for (int j = 0; j < iconsMap1.length; j++) {
				if (iconsMap1[i][j] != null)
					g.drawImage(iconsMap1[i][j].getImage(), i * eleWidth, j * eleHeight, eleWidth, eleHeight, null);
			}
		}
		for (int i = 0; i < iconsMap2[0].length; i++) {
			for (int j = 0; j < iconsMap2.length; j++) {
				if (iconsMap2[i][j] != null)
					g.drawImage(iconsMap2[i][j].getImage(), i * eleWidth, j * eleHeight, eleWidth, eleHeight, null);
			}
		}
	}

	private void read() {

		String path = getClass().getResource(relativePath).getPath();
		try (FileInputStream fin = new FileInputStream(path); DataInputStream din = new DataInputStream(fin);) {
			for (int i = 0; i < map1.length; i++) {
				for (int j = 0; j < map1.length; j++) {
					map1[i][j] = din.readInt();
					map2[i][j] = din.readInt();
				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		getIconsMap();
	}

	private void getIconsMap() {

		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1.length; j++) {
				iconsMap1[i][j] = icons[map1[i][j]];
				iconsMap2[i][j] = icons[map2[i][j]];
			}
		}
	}
}
