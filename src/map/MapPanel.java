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

public class MapPanel extends JPanel implements MapConfig{
	
	JLabel label = new JLabel();
	JComboBox boxtype;
	JComboBox groundBox;
	JComboBox cornerBox;
	JComboBox roadBox;
	
	public MapPanel() {
		
		//scroll pane		
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(MapWidth, MapHeight));
		//add listener
		centerPanel.addMouseListener(new PanelListener(this, label));	
		JScrollPane js = new JScrollPane(centerPanel);			
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1200, 700));		
		this.add(js, BorderLayout.CENTER);
				
		//итн╙ combobox
		JPanel east = new JPanel();
		this.add(east, BorderLayout.EAST);
		east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));		
		addCombobox(east);
		
		//add save button
		JButton save = new JButton("save");
		save.setActionCommand("save");
		save.addActionListener(new ButtonListener());
		east.add(save);
				
	}

	public static ImageIcon creatImageIcon(String path) {
		java.net.URL imgURL = MapConfig.class.getResource(path);
			if(imgURL != null) {
				return new ImageIcon(imgURL);
			}else	
		return null;
	}
	
	//add combo box to the east panel
	private void addCombobox(JPanel east) {
						
		boxtype = new JComboBox<Integer>();		
		groundBox = new JComboBox<ImageIcon>();
		cornerBox = new JComboBox<ImageIcon>();
		roadBox = new JComboBox<ImageIcon>();
						
		boxtype.addItem(1);
		boxtype.addItem(2);
				
		for(int i=0; i<iconsName_ground.length; i++) {
			icons_ground[i] = creatImageIcon("/img/" + iconsName_ground[i] + ".jpg");
			groundBox.addItem(icons_ground[i]);
		}
		for(int i=0; i<iconsName_corner.length; i++) {
			icons_corner[i] = creatImageIcon("/img/" + iconsName_corner[i] + ".jpg");
			cornerBox.addItem(icons_corner[i]);
		}		
		for(int i=0; i<iconsName_road.length; i++) {
			icons_road[i] = creatImageIcon("/img/" + iconsName_road[i] + ".jpg");
			roadBox.addItem(icons_road[i]);
		}
		
		groundBox.setMaximumSize(new Dimension(150, 150));
		cornerBox.setMaximumSize(new Dimension(150, 150));
		roadBox.setMaximumSize(new Dimension(150, 150));
		
		ItemListener ilis = new BoxListener(label);
		boxtype.addItemListener(ilis);	
		groundBox.addItemListener(ilis);	
		cornerBox.addItemListener(ilis);	
		roadBox.addItemListener(ilis);	
				
		east.add(label);
		east.add(Box.createRigidArea(new Dimension(0, 40)));		
		east.add(boxtype);
		boxtype.setMaximumSize(new Dimension(50, 20));
		
		east.add(groundBox);
		east.add(cornerBox);
		east.add(roadBox);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);	
		for(int i=0; i<iconsMap1[0].length; i++) {
			for(int j=0; j<iconsMap1.length; j++) {
				if(iconsMap1[i][j] != null)
					g.drawImage(iconsMap1[i][j].getImage(), i*eleWidth, j*eleHeight, eleWidth, eleHeight, null);
			}
		}
		for(int i=0; i<iconsMap2[0].length; i++) {
			for(int j=0; j<iconsMap2.length; j++) {
				if(iconsMap2[i][j] != null)
					g.drawImage(iconsMap2[i][j].getImage(), i*eleWidth, j*eleHeight, eleWidth, eleHeight, null);
			}
		}
	}
}
