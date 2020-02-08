package map;

import javax.swing.ImageIcon;

public interface MapConfig {
	
	//素材的大小  
    int eleWidth = 50;  
    int eleHeight = 50; 
    
    //地图的大小  
    int MapWidth = 2000;  
    int MapHeight= 2000; 
    
    //地图保存的位置  
    
    String path = "D:\\javacode\\eclipseProject\\RPG";  
      
    //用到的图片素材 
    
    ImageIcon icon0 = new ImageIcon("grass.jpg");  
    ImageIcon icon1 = new ImageIcon("tree.jpg");  
  
    //将所有的图片素材对象放入一个数组中，便于窗体上的下拉列表添加所有的图片素材  
    ImageIcon[] allicons = {icon0,icon1}; 
}
