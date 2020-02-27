package gameboard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import listener.KeyInput;
import map.MapReader;
import things.Player;

public class GamePanel extends JPanel implements GameConfig, Runnable {

	Player player;
	
	public GamePanel(Player player) {
		
		this.player = player;

		//JPanel setting
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1200, 700));
		this.setFocusable(true);
		this.addKeyListener(new KeyInput(player));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(mapWidth, mapHeight));
		
		this.add(centerPanel, BorderLayout.CENTER);
		
		new MapReader().readMap();
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		if (largeImgIcons.isEmpty())
			MapReader.setIcons();

		for (int i = 0; i < largeIconsMap1[0].length; i++) {
			for (int j = 0; j < largeIconsMap1.length; j++) {
				if (largeIconsMap1[i][j] != null)
					largeIconsMap1[i][j].paintIcon(null, g, i * eleWidth, j * eleHeight);
			}
		}
		for (int i = 0; i < largeIconsMap2[0].length; i++) {
			for (int j = 0; j < largeIconsMap2.length; j++) {
				if (largeIconsMap2[i][j] != null)
					largeIconsMap2[i][j].paintIcon(null, g, i * eleWidth, j * eleHeight);
			}
		}
		
		//draw player icon
		player.icon.paintIcon(this, g, player.bx, player.by);		
	}

	@Override
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
