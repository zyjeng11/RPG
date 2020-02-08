package map;

import javax.swing.ImageIcon;

public interface MapConfig {
		
    int eleWidth = 50;  
    int eleHeight = 50; 
   
    int MapWidth = 2000;  
    int MapHeight= 2000; 
    
         
    String path = "D:\\javacode\\eclipseProject\\RPG";  
    
    String[] iconsName = {"grass", "tree"};
	ImageIcon[] icons = new ImageIcon[2];

}
