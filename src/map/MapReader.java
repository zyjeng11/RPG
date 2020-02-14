package map;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;

public class MapReader implements MapConfig {

	public void readMap() {
		
		Map.setIcons();
		
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

	private void getIconsMap() {
		// turn map array to iconsMap array
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1.length; j++) {								
				iconsMap1[i][j] = icons_ground[map1[i][j]];
				iconsMap2[i][j] = icons_ground[map2[i][j]];
			}
		}		
	}
	private ImageIcon numberToImage(int num, int i, int j) {
		
		ImageIcon icon = null;
		
		if(num<200) {//flat element
			if(num/10 == 0) {//grass
				if(num/100 == 0)
					icon = icons_ground[0];
				else if(num/100 == 1)
					icon = icons_ground[1];
				else if(num/100 == 2)
					icon = icons_ground[2];
				else if(num/100 == 3)
					icon = icons_ground[3];
				
			}else if(num/10 == 1) {//ground
				if(num/100 == 0)
					icon = icons_ground[4];
				else if(num/100 == 1)
					icon = icons_ground[5];
				else if(num/100 == 2)
					icon = icons_ground[6];
				
			}else if(num/10 == 2) {//grass-ground
				if(num/100 == 7)
					icon = icons_corner[0];
				else if(num/100 == 0)
					icon = icons_corner[1];
				else if(num/100 == 1)
					icon = icons_corner[2];
				else if(num/100 == 9)
					icon = icons_corner[3];
				
			}else if(num/10 == 3) {//stone road
				if(num/100 == 0)
					icon = icons_road[0];
				else if(num/100 == 1)
					icon = icons_road[1];
				else if(num/100 == 2)
					icon = icons_road[2];
				else if(num/100 == 3)
					icon = icons_road[3];
				else if(num/100 == 4)
					icon = icons_road[4];
				else if(num/100 == 5)
					icon = icons_road[5];
				else if(num/100 == 6)
					icon = icons_road[6];
				else if(num/100 == 7)
					icon = icons_road[7];
				else if(num/100 == 8)
					icon = icons_road[8];
				else if(num/100 == 9)
					icon = icons_road[9];
			}								
		}	
		return icon;
	}
	
}
