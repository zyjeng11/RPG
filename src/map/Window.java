package map;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;

public class Window{
	
	String[] iconsName = {"grass", "tree"};
	ImageIcon[] icons = new ImageIcon[2];
	static JFrame frame;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Window().showGUI();
			}
		});
	}

	private void showGUI() {
		
		frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setPreferredSize(new Dimension(1200, 700));		
		frame.add(new ScrolledPanel());					
		frame.pack();
		
		addCombobox();
		
		frame.setVisible(true);
	}
	
	private void addCombobox() {
		JComboBox boxtype = new JComboBox<Integer>();
		JComboBox box = new JComboBox<ImageIcon>();
		
		boxtype.addItem(1);
		boxtype.addItem(2);
		
		for(int i=0; i<2; i++) {
			icons[i] = creatImageIcon("/img/"+ iconsName[i] +".jpg");
			box.addItem(icons[i]);
		}
		
		frame.add(boxtype);
		frame.add(box);
	}
	
	private ImageIcon creatImageIcon(String path) {
		java.net.URL imgURL = ScrolledPanel.class.getResource(path);
		if(imgURL != null) {
			return new ImageIcon(imgURL);
		}else	
		return null;
	}
}


