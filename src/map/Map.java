package map;

import java.awt.*;
import java.awt.event.ItemListener;
import javax.swing.*;
import listener.*;

public class Map implements MapConfig {

	public static JPanel mapPanel;
	JPanel east;
	JLabel label;
	MapPanel centerPanel;
	JComboBox boxtype;
	JComboBox groundBox;
	JComboBox cornerBox;
	JComboBox roadBox;
	JComboBox junctionBox;

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
		
		
		east = new JPanel();
		mapPanel.add(east, BorderLayout.EAST);
		east.setLayout(new GridLayout(12, 3));		
        
		for(ImageIcon[] ii: icons) {
			for(ImageIcon i: ii) {
				addButtons(i);
			}
		}

		// add save button
		JButton save = new JButton("save");
		save.setActionCommand("save");
		save.addActionListener(new ButtonListener(mapPanel, null));
		east.add(save);

		// add load button
		JButton load = new JButton("load");
		load.setActionCommand("load");
		load.addActionListener(new ButtonListener(centerPanel, null));
		east.add(load);
		
		east.add(label);

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
		for (int i = 0; i < iconsName_junction.length; i++) {
			icons_junction[i] = creatImageIcon("/img/" + iconsName_junction[i] + ".jpg");
		}
	}

	private void addButtons(ImageIcon img) {
		
		JButton bt = new JButton(img);
		bt.setActionCommand("image");
		bt.addActionListener(new ButtonListener(null, label));
		east.add(bt);
		
	}
	
	// add combo box to the east panel
	private void addCombobox(JPanel east) {

		boxtype = new JComboBox<Integer>();
		groundBox = new JComboBox<ImageIcon>();
		cornerBox = new JComboBox<ImageIcon>();
		roadBox = new JComboBox<ImageIcon>();
		junctionBox = new JComboBox<ImageIcon>();
		JComboBox[] boxes = {groundBox, cornerBox, roadBox, junctionBox};

		boxtype.addItem(1);
		boxtype.addItem(2);

		for (int i = 0; i < iconsName_ground.length; i++) {
			groundBox.addItem(icons_ground[i]);
		}
		
		for (int i = 0; i < iconsName_road.length; i++) {
			roadBox.addItem(icons_road[i]);
		}
		for (int i = 0; i < iconsName_corner.length; i++) {
			cornerBox.addItem(icons_corner[i]);
		}
		for (int i = 0; i < iconsName_junction.length; i++) {
			junctionBox.addItem(icons_junction[i]);
		}
		
		east.add(label);
		east.add(boxtype);
		boxtype.setMaximumSize(new Dimension(50, 20));
		for(JComboBox box: boxes) {
			setComboBox(box, east);
		}
				
	}

	private void setComboBox(JComboBox box, JPanel east) {

		box.setMaximumSize(new Dimension(70, 70));
		box.addItemListener(new BoxListener(label));
		east.add(box);
	}
}
