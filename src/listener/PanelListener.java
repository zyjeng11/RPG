package listener;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import map.MapConfig;
import map_part.MapPanel;

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

		int i = e.getX() / mapEleWidth;
		int j = e.getY() / mapEleHeight;

		Icon icon = label.getIcon();
		if (icon == null) {
			return;
		}

		// convert icons to number

		int iconNum = getKey(numberAndSmallImage, icon);

		BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();// draw into BufferedImage
		icon.paintIcon(null, g, 0, 0);
		ImageIcon ii = new ImageIcon((Image) bi);

		smallIconsMap1[i][j] = ii;

		// write map
		if (iconNum < 200)
			map1[i][j] = iconNum;

		panel.repaint();

	}

	public <K, V> K getKey(Map<K, V> map, V value) {
		for (Entry<K, V> entry : map.entrySet()) {
			if (entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		return null;
	}

}
