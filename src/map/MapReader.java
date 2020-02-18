package map;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;

public class MapReader implements MapConfig {

	public void readMap() {

		if(smallImgIcons.isEmpty())
			setSmallIcons();

		// read map from file
		String path = getClass().getResource(mapPath).getPath();
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

		//fill iconsMap array base on map array
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1.length; j++) {
								
				ImageIcon ii = numberAndImage.get(map1[i][j]);
				if (ii != null)
					iconsMap1[i][j] = ii;
			}
		}
	}

	public static HashMap createHashMap() {
		
		if(smallImgIcons.isEmpty()) {
			setSmallIcons();
		}
		
		HashMap<Integer, ImageIcon> numberAndImage = new HashMap<>();
		for(int i=0; i<imgNames.size(); i++) {
			numberAndImage.put(i, smallImgIcons.get(i));
		}
		
		return numberAndImage;
	}	

	private void setLargeIcons() {
		for (int i = 0; i < imgNames.size(); i++) {
			largeImgIcons.add(creatImageIcon("/img/100/" + imgNames.get(i)));
		}
	}
	
	public static ImageIcon creatImageIcon(String path) {
		java.net.URL imgURL = MapReader.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.out.println("file not found");
			return null;
		}
	}

	public static void setSmallIcons() {
		// load the image from file
		System.out.println("setSmallIcons");
		for (int i = 0; i < imgNames.size(); i++) {
			smallImgIcons.add(creatImageIcon("/img/50/" + imgNames.get(i)));
		}
	}
}
