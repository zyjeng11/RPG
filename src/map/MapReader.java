package map;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MapReader implements MapConfig {

	public void readMap() {

		if(smallImgIcons.isEmpty() || largeImgIcons.isEmpty())
			setIcons();		

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

		//fill small/large IconsMap array base on map array
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1.length; j++) {								
				Icon si = numberAndSmallImage.get(map1[i][j]);				
				if (si != null)
					smallIconsMap1[i][j] = si;
				Icon li = numberAndLargeImage.get(map1[i][j]);				
				if (li != null)
					largeIconsMap1[i][j] = li;
			}
		}
	}
	
	public static void readGameMap() {
		if(largeImgIcons.isEmpty())
			setIcons();		

		// read map from file
		String path = MapReader.class.getResource(mapPath).getPath();
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

		//fill largeIconsMap array base on map array
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1.length; j++) {								
				Icon ii = numberAndLargeImage.get(map1[i][j]);				
				if (ii != null)
					largeIconsMap1[i][j] = ii;
			}
		}
	}

	public static HashMap<Integer, Icon> createHashMap(List<Icon> ImgIcons) {
		
		if(ImgIcons.isEmpty()) {
			setIcons();
		}
		
		HashMap<Integer, Icon> numberAndImage = new HashMap<>();
		for(int i=0; i<imgNames.size(); i++) {
			numberAndImage.put(i, ImgIcons.get(i));
		}
		
		return numberAndImage;
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

	public static void setIcons() {
		// load the image from file
		System.out.println("setIcons");
		for (int i = 0; i < imgNames.size(); i++) {
			smallImgIcons.add(creatImageIcon("/img/50/" + imgNames.get(i)));
			largeImgIcons.add(creatImageIcon("/img/100/" + imgNames.get(i)));
		}
	}

}
