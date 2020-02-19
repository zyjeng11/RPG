package map_part;

import java.awt.Graphics;

import javax.swing.JPanel;

import map.MapConfig;

public class MapPanel extends JPanel implements MapConfig{
		
	@Override
	public void paint(Graphics g) {
		super.paint(g);	
		
		for(int i=0; i<smallIconsMap1[0].length; i++) {
			for(int j=0; j<smallIconsMap1.length; j++) {
				if(smallIconsMap1[i][j] != null)
					smallIconsMap1[i][j].paintIcon(null, g, i*mapEleWidth, j*mapEleHeight);
			}
		}
		for(int i=0; i<smallIconsMap2[0].length; i++) {
			for(int j=0; j<smallIconsMap2.length; j++) {
				if(smallIconsMap2[i][j] != null)
					smallIconsMap1[i][j].paintIcon(null, g, i*mapEleWidth, j*mapEleHeight);
			}
		}
	}
}
