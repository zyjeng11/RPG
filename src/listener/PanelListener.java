package listener;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import map.MapConfig;

public class PanelListener extends MouseAdapter implements MapConfig {

	private JPanel panel;
	private JLabel label;
	
	public PanelListener(JPanel panel, JLabel label) {
		this.panel = panel;
		this.label = label;
	}
	
	static Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon)icon).getImage();
        } else {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            GraphicsEnvironment ge =
              GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(w, h);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
    }
	@Override
	public void mouseClicked(MouseEvent e) {

		int i = e.getX() / 50;
		int j = e.getY() / 50;
		
		Icon icon = label.getIcon();
		BufferedImage bi = new BufferedImage(icon.getIconWidth(),
                icon.getIconHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();//draw into BufferedImage
        icon.paintIcon(null, g, 0, 0);
		//ImageIcon imgi = new ImageIcon((Image)bi);
		ImageIcon ii = new ImageIcon((Image)bi);
		
		iconsMap1[i][j] = ii;
		if (icon.toString().contains("grass_ground")) { // grass_ground 2
			if (icon.toString().endsWith("verticle_0.jpg"))
				map1[i][j] = 120;
			else if (icon.toString().endsWith("verticle_1.jpg"))
				map1[i][j] = 121;
			else if (icon.toString().endsWith("corner_7.jpg"))
				map1[i][j] = 122;

		} else if (icon.toString().contains("grass")) { // grass 0

			if (icon.toString().endsWith("0.jpg"))
				map1[i][j] = 100;
			else if (icon.toString().endsWith("1.jpg"))
				map1[i][j] = 101;
			else if (icon.toString().endsWith("2.jpg"))
				map1[i][j] = 102;
			else if (icon.toString().endsWith("3.jpg"))
				map1[i][j] = 103;

		} else if (icon.toString().contains("ground")) { // ground 1

			if (icon.toString().endsWith("0.jpg"))
				map1[i][j] = 110;
			else if (icon.toString().endsWith("1.jpg"))
				map1[i][j] = 111;
			else if (icon.toString().endsWith("2.jpg"))
				map1[i][j] = 112;

		} else if (icon.toString().contains("stone")) { // stone_road 3

			if (icon.toString().endsWith("0.jpg"))
				map1[i][j] = 130;
			else if (icon.toString().endsWith("1.jpg"))
				map1[i][j] = 131;
			else if (icon.toString().endsWith("2.jpg"))
				map1[i][j] = 132;
			else if (icon.toString().endsWith("3.jpg"))
				map1[i][j] = 133;
			else if (icon.toString().endsWith("4.jpg"))
				map1[i][j] = 134;
			else if (icon.toString().endsWith("5.jpg"))
				map1[i][j] = 135;
			else if (icon.toString().endsWith("6.jpg"))
				map1[i][j] = 136;
			else if (icon.toString().endsWith("7.jpg"))
				map1[i][j] = 137;
			else if (icon.toString().endsWith("8.jpg"))
				map1[i][j] = 138;
			else if (icon.toString().endsWith("9.jpg"))
				map1[i][j] = 139;

		}

		panel.repaint();
	}
}
