package things;

import javax.swing.Icon;

import gameboard.GameConfig;
import map.MapReader;

public class Player implements Runnable, GameConfig {

	private String playerImagUrl = "/img/item/player.png";
	public Icon icon;

	public int bx = boardWidth / 2 - eleWidth / 2;
	public int by = boardHeight / 2 - eleHeight / 2;

	public int width = 50;
	public int height = 50;

	// map drift
	public int mx = 0;
	public int my = 0;

	private int v = 10;

	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;

	public Player() {
		icon = MapReader.creatImageIcon(playerImagUrl);
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	@Override
	public void run() {

		while (true) {

			move();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void move() {

		// move by repaint the player
		if (my + by < boardHeight / 2 || my + by > mapHeight - boardHeight / 2) {
			// reach upper bound or bottom bound			
			if (up) {
				by -= v;
			}
			if (down) {
				by += v;
			}
		}
		else if (mx + bx < boardWidth / 2 || mx + bx > mapWidth - boardWidth / 2) {
			// reach right bound or left bound
			if (left) {
				bx -= v;
			}
			if (right) {
				bx += v;
			}
			
		} else {
			// move by repaint the map
			if (left) {
				mx -= v;
			}
			if (right) {
				mx += v;
			}

			if (up) {
				my -= v;
			}
			if (down) {
				my += v;
			}
		}
	}}
