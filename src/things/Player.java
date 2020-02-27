package things;

import javax.swing.Icon;

import gameboard.GameConfig;
import map.MapReader;

public class Player implements Runnable, GameConfig {

	private String playerImagUrl = "/img/item/player.png";
	public Icon icon;

	final public int bx = boardWidth / 2 - eleWidth / 2;
	final public int by = boardHeight / 2 - eleHeight / 2;

	public int width = 50;
	public int height = 50;

	// location related to map
	private int x = 250;
	private int y = 250;

	// element drift
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

		if (left) {
			x -= v;
			if (mx > 0)
				mx -= v;
		}
		if (right) {
			x += v;
			if (mx < mapWidth)
				mx += v;
		}

		if (up) {
			if(my > 0)
			my -= v;
		}
		if (down) {
			if(my < mapHeight)
			my += v;
		}

	}
}
