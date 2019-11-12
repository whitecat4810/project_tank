package com.aufe.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	
	private static final int SPEED = 10; //子弹速度
	private static final int WIDTH = 10, HEIGHT = 10; //子弹速度
	private int x, y;	//子弹位置
	private Direction dir;	//子弹方向
	private boolean inside = true;	//子弹是否出界,true为未出界
	private TankFrame frame;
	/**
	 * 创建子弹
	 * @param g
	 */
	public void paint(Graphics g) {
		
		if (!inside) {
			frame.bullets.remove(this);
		}
		
		switch (dir) {
			case LEFT:
				g.drawImage(ResourceManager.bulletL, x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourceManager.bulletR, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceManager.bulletU, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceManager.bulletD, x, y, null);
				break;
	
			default:
				break;
		}
		//g.drawImage(ResourceManager.bulletD, x, y, null);
		
		move();
		
	}
	
	/**
	 * 子弹移动
	 */
	private void move() {
		
		switch (dir) {
			case LEFT:
				x -= SPEED;
				break;
			case UP:
				y -= SPEED;
				break;
			case RIGHT:
				x += SPEED;
				break;
			case DOWN:
				y += SPEED;
				break;
	
			default:
				break;
		}
		
		if (x < 0 || y < 0 || 
				x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			inside = false;
		}
		
	}

	public Bullet(int x, int y, Direction dir, TankFrame frame) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.frame = frame;
	}
	
}
