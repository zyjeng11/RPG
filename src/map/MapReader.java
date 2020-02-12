package map;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MapReader implements MapConfig{
		
	public void readMap() {
	//read map from file
		for (int i = 0; i < 2; i++) {
			icons[i] = MapPanel.creatImageIcon("/img/" + iconsName[i] + ".jpg");
		}				

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
		//turn map file to icons array
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1.length; j++) {
				iconsMap1[i][j] = icons[map1[i][j]];
				iconsMap2[i][j] = icons[map2[i][j]];
			}
		}
	}
}
