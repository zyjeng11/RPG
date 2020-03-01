package map;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileName {

	public static void main(String[] args) {
		String imgPath = "/img/50/";
		List<String> imgNames = FileName.getFileName(imgPath);
		System.out.println(imgNames);
	}

	public static List<String> getFileName(String imgPath) {

		System.out.println("getfilename");

		List<String> imgNames = new ArrayList<>();
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

		System.out.println(imgNames);

		return imgNames;
	}
}
