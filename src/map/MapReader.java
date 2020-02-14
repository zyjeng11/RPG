package map;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

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

		getIconsMap();
	}

	private void setIcons() {
		
		for (int i = 0; i < 2; i++) {
			icons_ground[i] = Map.creatImageIcon("/img/" + iconsName_ground[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_ground.length; i++) {
			icons_ground[i] = Map.creatImageIcon("/img/" + iconsName_ground[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_corner.length; i++) {
			icons_corner[i] = Map.creatImageIcon("/img/" + iconsName_corner[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_road.length; i++) {
			icons_road[i] = Map.creatImageIcon("/img/" + iconsName_road[i] + ".jpg");
		}
	}

	private void getIconsMap() {
// turn map array to iconsMap array
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1.length; j++) {
				iconsMap1[i][j] = icons_ground[map1[i][j]];
				iconsMap2[i][j] = icons_ground[map2[i][j]];
			}
		}
	}
}
