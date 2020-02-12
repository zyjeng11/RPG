package map;

import javax.swing.ImageIcon;

public interface MapConfig {
		
    int eleWidth = 50;  
    int eleHeight = 50; 
   
    int MapWidth = 1000;  
    int MapHeight= 1000; 
    
    String[] iconsName = {"grass_0", "grass_1", "grass_2", "grass_3", 
    		"ground_0", "ground_1", "ground_2", 
    		"grass_corner_7", "grass_ground_verticle_0", "grass_ground_verticle_1",
    		"ground_corner_9", 
    		"stone_road_1", "stone_road_2", "stone_road_3", "stone_road_4", "stone_road_5", "stone_road_6",
    		"stone_road_7", "stone_road_8", "stone_road_9"};
    
	ImageIcon[] icons = new ImageIcon[iconsName.length];
	String relativePath = "/img/map.map";		//relative path of the map file

	static int[][] map1 = new int[20][20];
	static int[][] map2 = new int[20][20];
	
	static ImageIcon[][] iconsMap1 = new ImageIcon[20][20];
	static ImageIcon[][] iconsMap2 = new ImageIcon[20][20];
}
