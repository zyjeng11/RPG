package test;

import java.io.File;
import java.util.*;

import map.MapConfig;

public class FileName{

	public static void main(String[] args) {
		List<String> s = new FileName().getFileName("/img/100");
		System.out.println(s);
	}
	
	public static List<String> getFileName(String imgPath) {
		
		ArrayList<String> imgNames = new ArrayList<>();
		String path = FileName.class.getResource(imgPath).getPath();
		File dir = new File(path);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				imgNames.add(child.getName());
			}
		} else {
			System.out.println("path not exist");
		}
		
		return imgNames;
	}

}
