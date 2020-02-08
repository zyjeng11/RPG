package map;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class PanelListener extends MouseAdapter implements MapConfig{
	
	private JComboBox box;
	
	public PanelListener(JComboBox box){
		this.box = box;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int i = e.getX()/50;
		int j = e.getY()/50;
		System.out.println(i+", "+j);
		
		ImageIcon icon = (ImageIcon)box.getSelectedItem();
		System.out.println(icon);
		
	}
}
