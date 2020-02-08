package test;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class PanelTest {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
				
		JPanel panelCenter = new JPanel();
		panelCenter.setPreferredSize(new Dimension(2000, 2000));
		JScrollPane jsp = new JScrollPane(panelCenter);
		jsp.setPreferredSize(new Dimension(600, 600));
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panel.add(jsp, BorderLayout.CENTER);
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
