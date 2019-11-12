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
		
		Color color = g.getColor();
		
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(color);
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
