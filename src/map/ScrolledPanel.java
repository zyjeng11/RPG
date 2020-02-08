package map;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrolledPanel extends JPanel implements MapConfig{
	
	public ScrolledPanel() {
		
		//scroll pane
		JLabel label = new JLabel(creatImageIcon("/img/river.jpg"));			
		JScrollPane js = new JScrollPane(label);
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1200, 700));
		this.add(js, BorderLayout.CENTER);
		
		//итн╙ combobox
		JPanel east = new JPanel();
		this.add(east, BorderLayout.EAST);
		east.setLayout(new FlowLayout(FlowLayout.CENTER));
		east.setPreferredSize(new Dimension(350, 0));
		addCombobox(east);
	}

	private ImageIcon creatImageIcon(String path) {
		java.net.URL imgURL = ScrolledPanel.class.getResource(path);
		if(imgURL != null) {
			return new ImageIcon(imgURL);
		}else	
		return null;
	}
	
	private void addCombobox(JPanel east) {
		JComboBox boxtype = new JComboBox<Integer>();
		JComboBox box = new JComboBox<ImageIcon>();
		
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
