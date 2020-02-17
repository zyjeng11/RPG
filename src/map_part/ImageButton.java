package map_part;

import javax.swing.*;

public class ImageButton extends JButton{

	private Icon icon;
	
	public ImageButton(Icon icon) {
		super(icon);
		this.icon = icon;
	}
	
	public Icon getIcon() {
		return icon;
	}
}
