package map;

import javax.swing.ImageIcon;

public interface MapConfig {
		
    int eleWidth = 50;  
    int eleHeight = 50; 
   
    int MapWidth = 1000;  
    int MapHeight= 1000; 
    
    String[] iconsName = {"grass", "tree"};
	ImageIcon[] icons = new ImageIcon[2];

	static int[][] map1 = new int[20][20];
	static int[][] map2 = new int[20][20];
	
	static ImageIcon[][] iconsMap1 = new ImageIcon[20][20];
	static ImageIcon[][] iconsMap2 = new ImageIcon[20][20];
}
