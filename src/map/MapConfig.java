package map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public interface MapConfig {
		
    int eleWidth = 100;  
    int eleHeight = 100; 
   
    int MapWidth = 2000;  
    int MapHeight= 2000; 
    
    String[] iconsType = {"ground", "road", "corner", "junction"};
    
    String[] iconsName_ground = {"grass_0", "grass_1", "grass_2", "grass_3", 
    		"ground_0", "ground_1", "ground_2"};    
    String[] iconsName_road = {"stone_road_1", "stone_road_2", "stone_road_3", "stone_road_4", "stone_road_5", "stone_road_6",
    		"stone_road_7", "stone_road_8", "stone_road_9"};          
    String[] iconsName_corner = {"ground_grass_1", "ground_grass_3", "ground_grass_7", "ground_grass_9"};
    String[] iconsName_junction = {"grass_ground_1", "grass_ground_2_0","grass_ground_2_1",
    		"grass_ground_3","grass_ground_4_0","grass_ground_4_1",
    		"grass_ground_5","grass_ground_6_0","grass_ground_6_1",
    		"grass_ground_7","grass_ground_8_0","grass_ground_8_1","grass_ground_9"};
    String[][] iconsNames = {iconsName_ground, iconsName_road, iconsName_corner, iconsName_junction};
    
    ImageIcon[] icons_ground = new ImageIcon[iconsName_ground.length];
	ImageIcon[] icons_road = new ImageIcon[iconsName_road.length];	
	ImageIcon[] icons_corner = new ImageIcon[iconsName_corner.length];
	ImageIcon[] icons_junction = new ImageIcon[iconsName_junction.length];
	ImageIcon[][] icons = {icons_ground, icons_road, icons_corner, icons_junction};
	
	String relativePath = "/img/map.map";		//relative path of the map file

	static int[][] map1 = new int[20][20];
	static int[][] map2 = new int[20][20];
	
	static ImageIcon[][] iconsMap1 = new ImageIcon[20][20];
	static ImageIcon[][] iconsMap2 = new ImageIcon[20][20];
	
}
