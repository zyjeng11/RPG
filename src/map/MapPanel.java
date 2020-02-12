package map;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import listener.ButtonListener;
import listener.PanelListener;

public class MapPanel extends JPanel implements MapConfig{
	
	JComboBox boxtype;
	JComboBox box;	
	
	public MapPanel() {
		
		//scroll pane		
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(MapWidth, MapHeight));
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
		
		//add listener
		js.addMouseListener(new PanelListener(box, this));	
	}

	public static ImageIcon creatImageIcon(String path) {
		java.net.URL imgURL = MapConfig.class.getResource(path);
			if(imgURL != null) {
				return new ImageIcon(imgURL);
			}else	
		return null;
	}
	
	//add combobox to the east panel
	private void addCombobox(JPanel east) {
		boxtype = new JComboBox<Integer>();
		box = new JComboBox<ImageIcon>();
		
		boxtype.addItem(1);
		boxtype.addItem(2);
		
		for(int i=0; i<iconsName.length; i++) {
			icons[i] = creatImageIcon("/img/"+ iconsName[i] +".jpg");
			box.addItem(icons[i]);
		}
		
		east.add(Box.createRigidArea(new Dimension(0, 40)));
		
		east.add(boxtype);
		boxtype.setMaximumSize(new Dimension(50, 20));
		
		east.add(box);
		box.setMaximumSize(new Dimension(100, 100));
		box.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));
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
