package map;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelListener extends MouseAdapter implements MapConfig{
	
	private JComboBox box;
	private JPanel panel;
	
	public PanelListener(JComboBox box, JPanel panel){
		this.box = box;
		this.panel = panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		int i = e.getX()/50;
		int j = e.getY()/50;
		System.out.println(i+", "+j);
		
		ImageIcon icon = (ImageIcon)box.getSelectedItem();
		System.out.println(icon);
		
		panel.repaint();
	}
}
