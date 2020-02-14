package test;

import javax.swing.ImageIcon;

import map.MapReader;

public class IconToNumberTest {
	public static void main(String[] args) {
		numberToImage(111);
		System.out.println(111/10%10);
		System.out.println(111%10);
	}

	private static ImageIcon numberToImage(int num) {

		ImageIcon icon = null;

		if (num < 200) {// flat element
			if (num/10%10 == 0) {// grass
				if (num % 100 == 0)
					System.out.println("grass0");
				else if (num % 10 == 1)
					System.out.println("grass1");
				else if (num % 10 == 2)
					System.out.println("grass2");
				else if (num % 10 == 3)
					System.out.println("grass3");
			}else if(num/10%10 == 1) {//ground
				if(num%10 == 0)
					System.out.println("ground0");
				else if(num%10 == 1)
					System.out.println("ground1");
				else if(num%10 == 2)
					System.out.println("ground2");
//			} else if (num / 10 == 2) {// grass-ground
//				if (num / 100 == 7)
//					icon = icons_corner[0];
//				else if (num / 100 == 0)
//					icon = icons_corner[1];
//				else if (num / 100 == 1)
//					icon = icons_corner[2];
//				else if (num / 100 == 9)
//					icon = icons_corner[3];
//
//			} else if (num / 10 == 3) {// stone road
//				if (num / 100 == 0)
//					icon = icons_road[0];
//				else if (num / 100 == 1)
//					icon = icons_road[1];
//				else if (num / 100 == 2)
//					icon = icons_road[2];
//				else if (num / 100 == 3)
//					icon = icons_road[3];
//				else if (num / 100 == 4)
//					icon = icons_road[4];
//				else if (num / 100 == 5)
//					icon = icons_road[5];
//				else if (num / 100 == 6)
//					icon = icons_road[6];
//				else if (num / 100 == 7)
//					icon = icons_road[7];
//				else if (num / 100 == 8)
//					icon = icons_road[8];
//				else if (num / 100 == 9)
//					icon = icons_road[9];
			}
		}
		return icon;
	}
}
