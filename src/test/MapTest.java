package test;

import map.MapConfig;

public class MapTest implements MapConfig{
	
	public void printMap() {
		for(int[] i: map1) {
			for(int j: i) {
				System.out.print(j + ", ");			
			}
			System.out.println();
		}
	}
}
