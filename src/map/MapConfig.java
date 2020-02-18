package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import test.FileName;

public interface MapConfig {
		
    int eleWidth = 100;  
    int eleHeight = 100; 
   
    int MapWidth = 2000;  
    int MapHeight= 2000; 
    
    String imgPath = "/img/100/";   
    List<String> imgNames = FileName.getFileName(imgPath);
    List<ImageIcon> smallImgIcons = new ArrayList<>();
    List<ImageIcon> largeImgIcons = new ArrayList<>();
    HashMap<Integer, ImageIcon> numberAndImage = MapReader.createHashMap();
	
	String mapPath = "/img/map.map";		//relative path of the map file

	static int[][] map1 = new int[20][20];
	static int[][] map2 = new int[20][20];
	
	static ImageIcon[][] iconsMap1 = new ImageIcon[20][20];
	static ImageIcon[][] iconsMap2 = new ImageIcon[20][20];
	
}
