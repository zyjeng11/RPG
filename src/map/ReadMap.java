package map;

import java.io.*;

public class ReadMap implements MapConfig{
	
	private void read() {
		
		String path = getClass().getResource(relativePath).getPath();
		try(FileInputStream fin = new FileInputStream(path);
			DataInputStream din = new DataInputStream(fin);)
		{
			for(int i=0; i<map1.length; i++) {
				for(int j=0; j<map1.length; j++) {
					map1[i][j] = din.readInt();
					map2[i][j] = din.readInt();
				}
			}
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
