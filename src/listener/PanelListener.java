package listener;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import map.MapConfig;
import map.MapPanel;

public class PanelListener extends MouseAdapter implements MapConfig {
//save map data into array and show it on panel

	private MapPanel panel;
	private JLabel label;

	public PanelListener(MapPanel panel, JLabel label) {
		this.panel = panel;
		this.label = label;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int i = e.getX() / eleWidth;
		int j = e.getY() / eleHeight;
		
		Icon icon = label.getIcon();		
		if (icon == null) {
			return;
		}
		
		BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();// draw into BufferedImage
		icon.paintIcon(null, g, 0, 0);
		ImageIcon ii = new ImageIcon((Image) bi);

		iconsMap1[i][j] = ii;
		
		//convert icons to number
		int iconNum = iconToNumber(icon, i, j);
		
		//write map
		if(iconNum < 200)
			map1[i][j] = iconNum;
		
		panel.repaint();
		
	}
	
	private int iconToNumber(Icon icon, int i, int j) {
		
		int iconNumber = 100;
		
		if (icon.toString().contains("grass_ground")) { // grass-ground 2
			iconNumber += 20;
			if (icon.toString().endsWith("verticle_0.jpg"))
				iconNumber += 0;
			else if (icon.toString().endsWith("verticle_1.jpg"))
				iconNumber += 1;
			else if (icon.toString().endsWith("corner_7.jpg"))
				iconNumber += 7;
			else if (icon.toString().endsWith("corner_9.jpg"))
				iconNumber += 9;

		} else if (icon.toString().contains("grass")) { // grass 0
			iconNumber += 0;
			if (icon.toString().endsWith("0.jpg"))
				iconNumber += 0;
			else if (icon.toString().endsWith("1.jpg"))
				iconNumber += 1;
			else if (icon.toString().endsWith("2.jpg"))
				iconNumber += 2;
			else if (icon.toString().endsWith("3.jpg"))
				iconNumber += 3;

		} else if (icon.toString().contains("ground")) { // ground 1
			iconNumber += 10;
			if (icon.toString().endsWith("0.jpg"))
				iconNumber += 0;
			else if (icon.toString().endsWith("1.jpg"))
				iconNumber += 1;
			else if (icon.toString().endsWith("2.jpg"))
				iconNumber += 2;

		} else if (icon.toString().contains("stone")) { // stone_road 3
			iconNumber += 30;
			if (icon.toString().endsWith("1.jpg"))
				iconNumber += 1;
			else if (icon.toString().endsWith("2.jpg"))
				iconNumber += 2;
			else if (icon.toString().endsWith("3.jpg"))
				iconNumber += 3;
			else if (icon.toString().endsWith("4.jpg"))
				iconNumber += 4;
			else if (icon.toString().endsWith("5.jpg"))
				iconNumber += 5;
			else if (icon.toString().endsWith("6.jpg"))
				iconNumber += 6;
			else if (icon.toString().endsWith("7.jpg"))
				iconNumber += 7;
			else if (icon.toString().endsWith("8.jpg"))
				iconNumber += 8;
			else if (icon.toString().endsWith("9.jpg"))
				iconNumber += 9;
		}
		
		return iconNumber;
	}
}
