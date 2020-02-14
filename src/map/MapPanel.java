package map;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MapPanel extends JPanel implements MapConfig{
		
	@Override
	public void paint(Graphics g) {
		System.out.println("repaint");
		super.paint(g);	
		for(int i=0; i<iconsMap1[0].length; i++) {
			for(int j=0; j<iconsMap1.length; j++) {
				if(iconsMap1[i][j] != null)
					g.drawImage(iconsMap1[i][j].getImage(), i*eleWidth, j*eleHeight, eleWidth, eleHeight, null);
			}
		}
		for(int i=0; i<iconsMap2[0].length; i++) {
			for(int j=0; j<iconsMap2.length; j++) {
				if(iconsMap2[i][j] != null)
					g.drawImage(iconsMap2[i][j].getImage(), i*eleWidth, j*eleHeight, eleWidth, eleHeight, null);
			}
		}
	}
}
