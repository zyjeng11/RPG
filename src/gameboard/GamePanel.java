package gameboard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import map.MapConfig;
import map.MapReader;

public class GamePanel extends JPanel implements MapConfig, Runnable {
	
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
		System.out.println("paint");
		super.paint(g);
		if(largeImgIcons.isEmpty())
			MapReader.setIcons();
		
		for (int i = 0; i < largeIconsMap1[0].length; i++) {
			for (int j = 0; j < largeIconsMap1.length; j++) {
				if (largeIconsMap1[i][j] != null)
					largeIconsMap1[i][j].paintIcon(null, g, i*gameEleWidth, j*gameEleHeight);
			}
		}
		for (int i = 0; i < largeIconsMap2[0].length; i++) {
			for (int j = 0; j < largeIconsMap2.length; j++) {
				if (largeIconsMap2[i][j] != null)
					largeIconsMap2[i][j].paintIcon(null, g, i*gameEleWidth, j*gameEleHeight);
			}
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(20);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
		
}
