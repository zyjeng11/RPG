package map;

import java.awt.*;
import java.awt.event.ItemListener;
import javax.swing.*;
import listener.*;
import map_part.ImageButton;
import map_part.MapPanel;

public class Map implements MapConfig {

	public static JPanel mapPanel;
	JPanel east;
	JLabel label;
	MapPanel centerPanel;

	public Map() {

		if(smallImgIcons.isEmpty())
			MapReader.setSmallIcons();
		
		label = new JLabel(smallImgIcons.get(0));

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

//		for (ImageIcon i : smallImgIcons)
//			addButtons(i);		
		for(int i=0; i<smallImgIcons.size(); i++) {
			addButtons(smallImgIcons.get(i));
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

	private void addButtons(ImageIcon img) {

		ImageButton bt = new ImageButton(img);
		bt.setActionCommand("image");
		bt.addActionListener(new ButtonListener(null, label, bt));
		east.add(bt);

	}

}
