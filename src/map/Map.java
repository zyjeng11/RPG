package map;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import listener.BoxListener;
import listener.ButtonListener;
import listener.PanelListener;

public class Map implements MapConfig {

	public static JPanel mapPanel;
	JLabel label;
	MapPanel centerPanel;
	JComboBox boxtype;
	JComboBox groundBox;
	JComboBox cornerBox;
	JComboBox roadBox;

	public Map() {

		setIcons();
		label = new JLabel(icons_ground[0]);

		mapPanel = new JPanel();

		// scroll pane
		centerPanel = new MapPanel();
		centerPanel.setPreferredSize(new Dimension(MapWidth, MapHeight));

		// add listener
		centerPanel.addMouseListener(new PanelListener(centerPanel, label));
		JScrollPane js = new JScrollPane(centerPanel);

		mapPanel.setLayout(new BorderLayout());
		mapPanel.setPreferredSize(new Dimension(1200, 700));
		mapPanel.add(js, BorderLayout.CENTER);

		// итн╙ combobox
		JPanel east = new JPanel();
		mapPanel.add(east, BorderLayout.EAST);
		east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
		addCombobox(east);

		// add save button
		JButton save = new JButton("save");
		save.setActionCommand("save");
		save.addActionListener(new ButtonListener(mapPanel));
		east.add(save);

		// add load button
		JButton load = new JButton("load");
		load.setActionCommand("load");
		load.addActionListener(new ButtonListener(centerPanel));
		east.add(load);

	}

	public static ImageIcon creatImageIcon(String path) {
		java.net.URL imgURL = MapConfig.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else
			return null;
	}

	public static void setIcons() {
		// load the image from file
		for (int i = 0; i < iconsName_ground.length; i++) {
			icons_ground[i] = creatImageIcon("/img/" + iconsName_ground[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_corner.length; i++) {
			icons_corner[i] = creatImageIcon("/img/" + iconsName_corner[i] + ".jpg");
		}
		for (int i = 0; i < iconsName_road.length; i++) {
			icons_road[i] = creatImageIcon("/img/" + iconsName_road[i] + ".jpg");
		}
	}

	// add combo box to the east panel
	private void addCombobox(JPanel east) {

		boxtype = new JComboBox<Integer>();
		groundBox = new JComboBox<ImageIcon>();
		cornerBox = new JComboBox<ImageIcon>();
		roadBox = new JComboBox<ImageIcon>();
		JComboBox[] boxes = {groundBox, cornerBox, roadBox};

		boxtype.addItem(1);
		boxtype.addItem(2);

		for (int i = 0; i < iconsName_ground.length; i++) {
			groundBox.addItem(icons_ground[i]);
		}
		for (int i = 0; i < iconsName_corner.length; i++) {
			cornerBox.addItem(icons_corner[i]);
		}
		for (int i = 0; i < iconsName_road.length; i++) {
			roadBox.addItem(icons_road[i]);
		}
		
		east.add(label);
		east.add(boxtype);
		boxtype.setMaximumSize(new Dimension(50, 20));
		for(JComboBox box: boxes) {
			setComboBox(box, east);
		}
				
	}

	private void setComboBox(JComboBox box, JPanel east) {

		box.setMaximumSize(new Dimension(150, 150));
		box.addItemListener(new BoxListener(label));
		east.add(box);
	}
}
