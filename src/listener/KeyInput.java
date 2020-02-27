package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import things.Player;

public class KeyInput extends KeyAdapter{

	Player player;
	
	public KeyInput(Player player) {
		this.player = player;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT) {
			player.setLeft(true);
		}else if(key == KeyEvent.VK_RIGHT) {
			player.setRight(true);
		}else if(key == KeyEvent.VK_UP) {
			player.setUp(true);
		}else if(key == KeyEvent.VK_DOWN) {
			player.setDown(true);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT) {
			player.setLeft(false);
		}else if(key == KeyEvent.VK_RIGHT) {
			player.setRight(false);
		}else if(key == KeyEvent.VK_UP) {
			player.setUp(false);
		}else if(key == KeyEvent.VK_DOWN) {
			player.setDown(false);
		}
	}
}
