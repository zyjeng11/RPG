package map;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrolledPanel extends JPanel implements MapConfig{
	
	JComboBox boxtype;
	JComboBox box;	
	
	public ScrolledPanel() {
		
		//scroll pane
		
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(2000, 2000));
		JScrollPane js = new JScrollPane(centerPanel);			
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1200, 700));		
		this.add(js, BorderLayout.CENTER);
				
		//итн╙ combobox
		JPanel east = new JPanel();
		this.add(east, BorderLayout.EAST);
		east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));		
		addCombobox(east);
		
		//add listener
		js.addMouseListener(new PanelListener(box, this));
	}

	private ImageIcon creatImageIcon(String path) {
		java.net.URL imgURL = ScrolledPanel.class.getResource(path);
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
		
		for(int i=0; i<2; i++) {
			icons[i] = creatImageIcon("/img/"+ iconsName[i] +".jpg");
			box.addItem(icons[i]);
		}		
		east.add(boxtype);
		east.add(box);
	}	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);		
	}
}
