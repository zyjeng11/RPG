package listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class BoxListener implements ItemListener{
	
	private JLabel label;
	JComboBox[] boxes;
	
	public BoxListener(JLabel label){
		this.label = label;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
				
		ImageIcon selected = (ImageIcon)e.getItem();		
		label.setIcon(selected);
		label.repaint();
	}
	
}
