package map;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import listener.ButtonListener;
import listener.PanelListener;
import map_part.ImageButton;
import map_part.MapPanel;
import map.MapConfig;

public class Map extends MapReader implements MapConfig {

	public JPanel mainPanel;
	JPanel east;
	JLabel label;
	MapPanel centerPanel;
	
	MapReader mapReader;

	public Map(MapReader mapReader) {
		
		System.out.println("mainPanel init");
		this.mapReader = mapReader;

		label = new JLabel(smallImgIcons.get(0));

		mainPanel = new JPanel();

		// scroll pane
		centerPanel = new MapPanel();
		centerPanel.setPreferredSize(new Dimension(MapWidth, MapHeight));

		// add listener
		centerPanel.addMouseListener(new PanelListener(centerPanel, label, numberAndSmallImage));
		JScrollPane js = new JScrollPane(centerPanel);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(1200, 700));
		mainPanel.add(js, BorderLayout.CENTER);

		east = new JPanel();
		mainPanel.add(east, BorderLayout.EAST);
		east.setLayout(new GridLayout(12, 3));

		for (int i = 0; i < smallImgIcons.size(); i++) {
			addButtons(smallImgIcons.get(i));
		}

		// add save button
		JButton save = new JButton("save");
		save.setActionCommand("save");
		save.addActionListener(new ButtonListener(mainPanel, null));
		east.add(save);

		// add load button
		JButton load = new JButton("load");
		load.setActionCommand("load");
		load.addActionListener(new ButtonListener(centerPanel, null));
		east.add(load);

		east.add(label);

	}

	private void addButtons(Icon icon) {

		ImageButton bt = new ImageButton(icon);
		bt.setActionCommand("image");
		bt.addActionListener(new ButtonListener(null, label, bt));
		east.add(bt);

	}

}
