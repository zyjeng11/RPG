package test;

import java.awt.*;

import javax.swing.*;

import map.MapConfig;

public class BoxLayoutTest implements MapConfig {

	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setVisible(true);

		JPanel east = new JPanel();
		

		for (ImageIcon[] ii : icons) {
			for (ImageIcon i : ii) {
				addButtons(east, i);
			}
		}
		frame.add(east, BorderLayout.EAST);
	}

	private static void addButtons(JPanel east, ImageIcon img) {

		JButton bt = new JButton(img);
		east.add(bt);

	}

}
