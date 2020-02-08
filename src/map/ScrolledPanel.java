package map;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrolledPanel extends JPanel{
	
	public ScrolledPanel() {
				
		JLabel label = new JLabel(creatImageIcon("/img/river.jpg"));			
		JScrollPane js = new JScrollPane(label);
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600, 600));
		this.add(js, BorderLayout.CENTER);
	}

	private ImageIcon creatImageIcon(String path) {
		java.net.URL imgURL = ScrolledPanel.class.getResource(path);
		if(imgURL != null) {
			return new ImageIcon(imgURL);
		}else	
		return null;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
	}
}
