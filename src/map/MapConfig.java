package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public interface MapConfig {
	
	//element size in map editor
    int mapEleWidth = 50;  
    int mapEleHeight = 50; 
    
    //40*50
    int MapWidth = 2000;  
    int MapHeight= 2000; 
    
    String imgPath = "/img/100/";   
    List<String> imgNames = FileName.getFileName(imgPath);
    List<Icon> smallImgIcons = new ArrayList<>();//assign value at MapReader.setIcons()
    
    HashMap<Integer, Icon> numberAndSmallImage = MapReader.createHashMap(smallImgIcons);
    
	
	String mapPath = "/img/map.map";		//relative path of the map file

	static int[][] map1 = new int[40][40];
	static int[][] map2 = new int[40][40];
	
	static Icon[][] smallIconsMap1 = new ImageIcon[40][40];
	static Icon[][] smallIconsMap2 = new ImageIcon[40][40];
	
}
