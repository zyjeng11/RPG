package gameboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import map.MapReader;

public interface GameConfig {
	//element size in game board
    int eleWidth = 100;  
    int eleHeight = 100; 
    
    //40*100
    int mapWidth = 4000;  
    int mapHeight= 4000; 
    
    int boardWidth = 1200;
    int boardHeight = 700;
    
	static Icon[][] largeIconsMap1 = new ImageIcon[40][40];
	static Icon[][] largeIconsMap2 = new ImageIcon[40][40];
}
