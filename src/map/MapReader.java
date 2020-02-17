package map;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;

public class MapReader implements MapConfig {

	public void readMap() {

		setIcons();

		// read map from file
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

		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1.length; j++) {

				ImageIcon ii = numberToImage(map1[i][j]);
				if (ii != null)
					iconsMap1[i][j] = ii;
			}
		}
	}

	private ImageIcon numberToImage(int num) {

		if(l_icons_ground[0] == null)
			setLargeIcon();
		
		ImageIcon icon = null;

		if (num < 200) {// flat element
			if (num / 10 % 10 == 0) {// grass
				if (num % 100 == 0)
					icon = l_icons_ground[0];
				else if (num % 10 == 1)
					icon = l_icons_ground[1];
				else if (num % 10 == 2)
					icon = l_icons_ground[2];
				else if (num % 10 == 3)
					icon = l_icons_ground[3];

			} else if (num / 10 % 10 == 1) {// ground
				if (num % 10 == 0)
					icon = l_icons_ground[4];
				else if (num % 10 == 1)
					icon = l_icons_ground[5];
				else if (num % 10 == 2)
					icon = l_icons_ground[6];

			} else if (num / 10 % 10 == 2) {// grass-ground
				if (num % 10 == 7)
					icon = l_icons_corner[0];
				else if (num % 10 == 0)
					icon = l_icons_corner[1];
				else if (num % 10 == 1)
					icon = l_icons_corner[2];
				else if (num % 10 == 9)
					icon = l_icons_corner[3];

			} else if (num / 10 % 10 == 3) {// stone road
				if (num % 10 == 0)
					icon = l_icons_road[0];
				else if (num % 10 == 1)
					icon = l_icons_road[1];
				else if (num % 10 == 2)
					icon = l_icons_road[2];
				else if (num % 10 == 3)
					icon = l_icons_road[3];
				else if (num % 10 == 4)
					icon = l_icons_road[4];
				else if (num % 10 == 5)
					icon = l_icons_road[5];
				else if (num % 10 == 6)
					icon = l_icons_road[6];
				else if (num % 10 == 7)
					icon = l_icons_road[7];
				else if (num % 10 == 8)
					icon = l_icons_road[8];
				else if (num % 10 == 9)
					icon = l_icons_road[9];
			}
		}
		return icon;
	}

	private void setLargeIcon() {
		for (int i = 0; i < iconsName_ground.length; i++) {
			l_icons_ground[i] = creatImageIcon("/img/100/" + iconsName_ground[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_corner.length; i++) {
			l_icons_corner[i] = creatImageIcon("/img/100/" + iconsName_corner[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_road.length; i++) {
			l_icons_road[i] = creatImageIcon("/img/100/" + iconsName_road[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_junction.length; i++) {
			l_icons_junction[i] = creatImageIcon("/img/100/" + iconsName_junction[i] + ".jpg");
		}
	}
	
	public static ImageIcon creatImageIcon(String path) {
		java.net.URL imgURL = MapConfig.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else
			return null;
	}

	public static void setIcons() {
		// load the image from file
		
		for (int i = 0; i < iconsName_ground.length; i++) {
			icons_ground[i] = creatImageIcon("/img/50/" + iconsName_ground[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_corner.length; i++) {
			icons_corner[i] = creatImageIcon("/img/50/" + iconsName_corner[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_road.length; i++) {
			icons_road[i] = creatImageIcon("/img/50/" + iconsName_road[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_junction.length; i++) {
			icons_junction[i] = creatImageIcon("/img/50/" + iconsName_junction[i] + ".jpg");
		}
	}
}
